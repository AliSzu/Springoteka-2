package Pracownia.Projekt.Spring.Exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMissingParams(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = String.format("Missing field with name: %s", request.toString());
        ErrorMessage errorResponse = new ErrorMessage(errorMessage,HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(EntityNotFoundException ex) {
        ErrorMessage errorResponse = new ErrorMessage(ex.getMessage(),HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorMessage errorResponse = new ErrorMessage(ex.getMessage(),HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}