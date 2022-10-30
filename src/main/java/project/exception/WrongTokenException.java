package project.exception;

import static project.util.StringPool.ERROR_RETURN_TICKET;

public class WrongTokenException extends RuntimeException {
    public WrongTokenException(String message) {
        super(message);
    }

    public WrongTokenException() {
        this(ERROR_RETURN_TICKET);
    }
}
