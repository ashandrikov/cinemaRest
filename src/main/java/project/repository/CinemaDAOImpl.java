package project.repository;

import org.springframework.stereotype.Repository;
import project.model.Seat;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaDAOImpl implements CinemaDAO {

    private List<Seat> availableSeatsList = new ArrayList<>();

    @Override
    public void initializeCinemaHall() {
        for (int i = 1; i <= ROWS; i++) {
            for (int j = 1; j <= COLS; j++) {
                availableSeatsList.add(new Seat(i, j));
            }
        }
    }

    @Override
    public List<Seat> getAllAvailableSeat(){
        return availableSeatsList;
    }

    @Override
    public void removeSeatFromAvailableList(Seat seat){
        availableSeatsList.remove(seat);
    }
}
