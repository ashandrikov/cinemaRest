package project.exception;

import static project.util.StringPool.WRONG_PASSWORD;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        this(WRONG_PASSWORD);
    }
}
