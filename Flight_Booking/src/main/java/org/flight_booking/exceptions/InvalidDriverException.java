package org.flight_booking.exceptions;

public class InvalidDriverException extends RuntimeException {
    public InvalidDriverException(String message) {
        super(message);
    }
}
