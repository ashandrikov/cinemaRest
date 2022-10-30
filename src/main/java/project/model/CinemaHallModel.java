package project.model;

import java.util.List;

public class CinemaHallModel {
    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats;

    public CinemaHallModel() {
    }

    public CinemaHallModel(List<Seat> available_seats) {
        this.total_rows = 9;
        this.total_columns = 9;
        this.available_seats = available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }
}

