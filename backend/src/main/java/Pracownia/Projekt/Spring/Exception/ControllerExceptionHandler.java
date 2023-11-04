package Pracownia.Projekt.Spring.Exception;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMissingParams(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = String.format("Missing field with name: %s", request.toString());
        ErrorMessage errorResponse = new ErrorMessage(errorMessage,HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(EntityNotFoundException ex) {
        ErrorMessage errorResponse = new ErrorMessage(ex.getMessage(),HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}