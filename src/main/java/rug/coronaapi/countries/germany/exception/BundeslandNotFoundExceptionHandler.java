package rug.coronaapi.countries.germany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class BundeslandNotFoundExceptionHandler {

    @ExceptionHandler(value = {BundeslandNotFoundException.class})
    public ResponseEntity<Object> handleBundeslandNotFoundException(BundeslandNotFoundException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        BundeslandException bundeslandException = new BundeslandException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(bundeslandException, badRequest);
    }
}
