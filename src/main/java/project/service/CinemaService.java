package project.service;

import org.springframework.stereotype.Service;
import project.model.CinemaHallModel;
import project.model.Seat;

import java.util.Map;

@Service
public interface CinemaService {

    CinemaHallModel getAllSeats();

    boolean validInputBookTicket(Seat seat);

    void deleteSeat(Seat seat);

    void addBookedSeatToTokenList(String token, Seat seat);

    Map<String, Seat> returnTicket(String token);

    Map<String, Integer> getStats(String password);
}
