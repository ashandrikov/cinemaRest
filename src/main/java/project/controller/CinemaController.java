package project.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.model.CinemaHallModel;
import project.model.Seat;
import project.model.SeatWithToken;
import project.model.Token;
import project.service.CinemaService;
import project.service.CinemaServiceImpl;

import java.util.Map;

import static java.util.UUID.randomUUID;
import static org.springframework.http.HttpStatus.OK;
import static project.util.StringPool.TICKET_BOOKED;

@RestController
@Slf4j
public class CinemaController {
    private CinemaService cinemaService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaController.class);

    @Autowired
    public CinemaController(CinemaServiceImpl cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public CinemaHallModel getHall() {
        return cinemaService.getAllSeats();
    }

    @PostMapping("/purchase")
    public SeatWithToken buyTicket(@RequestBody Seat seat) {
        cinemaService.validInputBookTicket(seat);
        cinemaService.deleteSeat(seat);
        String token  = String.valueOf(randomUUID());
        Seat newSeatFromRequestBody = new Seat(seat.getRow(), seat.getColumn());
        cinemaService.addBookedSeatToTokenList(token, newSeatFromRequestBody);
        LOGGER.info(TICKET_BOOKED, newSeatFromRequestBody.getRow(), newSeatFromRequestBody.getColumn(), newSeatFromRequestBody.getPrice());
        return new SeatWithToken(token, newSeatFromRequestBody);
    }

    @PostMapping("/return")
    public ResponseEntity<Map<String, Seat>> returnTicket(@RequestBody Token tokenModel){
        String token = tokenModel.getToken();
        return new ResponseEntity<>(cinemaService.returnTicket(token), OK);
    }

    @PostMapping("/stats")
    public ResponseEntity<Map<String, Integer>> getStats(@RequestParam (required = false) String password){
        return new ResponseEntity<>(cinemaService.getStats(password), OK);
    }
}

