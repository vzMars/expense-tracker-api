package dev.marcosgonzalez.expensetracker.exception;

import dev.marcosgonzalez.expensetracker.dto.ErrorMsgResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMsgResponse> validationErrors(MethodArgumentNotValidException ex) {
        ErrorMsgResponse error = new ErrorMsgResponse(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorMsgResponse> duplicateErrors(DuplicateException ex) {
        ErrorMsgResponse error = new ErrorMsgResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorMsgResponse> badCredentialsErrors(BadCredentialsException ex) {
        ErrorMsgResponse error = new ErrorMsgResponse("Incorrect username or password.");
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
