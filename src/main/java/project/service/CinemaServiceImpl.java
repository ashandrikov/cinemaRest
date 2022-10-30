package project.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.exception.WrongTokenException;
import project.exception.TicketHasBeenPurchased;
import project.exception.TicketOutOfBoundException;
import project.exception.WrongPasswordException;
import project.model.CinemaHallModel;
import project.model.Seat;
import project.repository.CinemaDAO;
import project.repository.CinemaDAOImpl;
import project.repository.StatisticDAO;
import project.repository.StatisticDAOImpl;
import project.repository.TicketDAO;
import project.repository.TicketDAOImpl;

import java.util.HashMap;
import java.util.Map;

import static project.repository.CinemaDAO.COLS;
import static project.repository.CinemaDAO.ROWS;
import static project.util.StringPool.ERROR_OUT_OF_BOUNDS;
import static project.util.StringPool.ERROR_PURCHASED;
import static project.util.StringPool.ERROR_RETURN_TICKET;
import static project.util.StringPool.GETTING_CINEMA_HALL;
import static project.util.StringPool.RETURN_TICKET;
import static project.util.StringPool.WRONG_PASSWORD;

@Service
@Slf4j
public class CinemaServiceImpl implements CinemaService{

    private CinemaDAO cinemaDao;
    private TicketDAO ticketDAO;
    private StatisticDAO statisticDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaServiceImpl.class);

    @Autowired
    public CinemaServiceImpl(CinemaDAOImpl cinemaDao, TicketDAOImpl ticketDAO, StatisticDAOImpl statisticDAO) {
        this.cinemaDao = cinemaDao;
        this.ticketDAO = ticketDAO;
        this.statisticDAO = statisticDAO;
        cinemaDao.initializeCinemaHall();
        statisticDAO.initialize(cinemaDao.getAllAvailableSeat().size());
    }

    @Override
    public CinemaHallModel getAllSeats(){
        LOGGER.info(GETTING_CINEMA_HALL);
        return new CinemaHallModel(cinemaDao.getAllAvailableSeat());
    }

    @Override
    public boolean validInputBookTicket(Seat seat){
        if (seat.getRow() > ROWS || seat.getColumn() > COLS || seat.getRow() < 1 || seat.getColumn() < 1) {
            LOGGER.error(ERROR_OUT_OF_BOUNDS, seat.getRow(), seat.getColumn());
            throw new TicketOutOfBoundException();
        } else if (!cinemaDao.getAllAvailableSeat().contains(seat)) {
            LOGGER.error(ERROR_PURCHASED, seat.getRow(), seat.getColumn());
            throw new TicketHasBeenPurchased();
        }
        return true;
    }

    @Override
    public void deleteSeat(Seat seat) {
        if (cinemaDao.getAllAvailableSeat().contains(seat)){
            cinemaDao.removeSeatFromAvailableList(seat);
        }
    }

    @Override
    public void addBookedSeatToTokenList(String token, Seat seat){
        ticketDAO.addTicketToList(token, seat);
        statisticDAO.changeStats(seat.getPrice(), -1, 1);
    }

    @Override
    public Map<String, Seat> returnTicket(String token){
        Map<String, Seat> response = new HashMap<>();
        if (ticketDAO.getTicketList().containsKey(token)){
            response.put("returned_ticket", ticketDAO.getTicketList().get(token));
            cinemaDao.getAllAvailableSeat().add(ticketDAO.getTicketList().get(token));
            statisticDAO.changeStats(-ticketDAO.getTicketList().get(token).getPrice(), 1, -1);
            ticketDAO.removeTicketFromListByToken(token);
            LOGGER.info(RETURN_TICKET);
        } else {
            LOGGER.error(ERROR_RETURN_TICKET);
            throw new WrongTokenException();
        }
        return response;
    }

    @Override
    public Map<String, Integer> getStats(String password){
        if ("super_secret".equals(password)){
            return statisticDAO.getStats();
        } else {
            LOGGER.error(WRONG_PASSWORD);
            throw new WrongPasswordException();
        }
    }
}
