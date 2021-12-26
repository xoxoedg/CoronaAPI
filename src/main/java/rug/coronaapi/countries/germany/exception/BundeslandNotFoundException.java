package rug.coronaapi.countries.germany.exception;

public class BundeslandNotFoundException extends RuntimeException {

    public BundeslandNotFoundException(String message) {
        super(message);
    }

    public BundeslandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
