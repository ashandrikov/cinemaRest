package project.repository;

import project.model.Seat;

import java.util.List;

public interface CinemaDAO {
    int ROWS = 9;
    int COLS = 9;

    void initializeCinemaHall();

    List<Seat> getAllAvailableSeat();

    void removeSeatFromAvailableList(Seat seat);
}
