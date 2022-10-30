package project.exception;

import static project.util.StringPool.EXCEPTION_OUT_OF_BOUNDS;

public class TicketOutOfBoundException extends RuntimeException {
    public TicketOutOfBoundException(String message) {
        super(message);
    }

    public TicketOutOfBoundException() {
        this(EXCEPTION_OUT_OF_BOUNDS);
    }
}
