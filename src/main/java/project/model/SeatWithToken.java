package project.model;

public class SeatWithToken {
    private String token;
    private Seat ticket;

    public SeatWithToken(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}
