package project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({TicketOutOfBoundException.class, TicketHasBeenPurchased.class, WrongTokenException.class, WrongPasswordException.class})
    public ResponseEntity<Map<String, String>> handleException(RuntimeException ex){
        if (ex instanceof TicketOutOfBoundException || ex instanceof TicketHasBeenPurchased || ex instanceof WrongTokenException){
            return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof WrongPasswordException){
            return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.UNAUTHORIZED);
        }
        return null;
    }
}
