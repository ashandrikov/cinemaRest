package project.util;

public class StringPool {
    public static final String GETTING_CINEMA_HALL = "Getting cinema hall model with all available seats";
    public static final String ERROR_OUT_OF_BOUNDS = "The number of parameters: Row: {}, Seat: {} is out of bounds!";
    public static final String EXCEPTION_OUT_OF_BOUNDS = "The number of a row or a column is out of bounds!";
    public static final String ERROR_PURCHASED = "The ticket with params: Row: {}, Seat: {} has been already purchased!";
    public static final String EXCEPTION_PURCHASED = "The ticket has been already purchased!";
    public static final String RETURN_TICKET = "The ticket has been returned successfully!";
    public static final String ERROR_RETURN_TICKET = "Wrong token!";
    public static final String TICKET_BOOKED = "Row: {}, Seat: {}, Price: {}. You have a ticket!";
    public static final String WRONG_PASSWORD = "The password is wrong!";

    private StringPool() {
        throw new IllegalStateException("Utility class");
    }
}
