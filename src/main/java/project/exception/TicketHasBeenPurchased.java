package project.exception;

import static project.util.StringPool.EXCEPTION_PURCHASED;

public class TicketHasBeenPurchased extends RuntimeException {
    public TicketHasBeenPurchased(String message) {
        super(message);
    }

    public TicketHasBeenPurchased() {
        this(EXCEPTION_PURCHASED);
    }
}
