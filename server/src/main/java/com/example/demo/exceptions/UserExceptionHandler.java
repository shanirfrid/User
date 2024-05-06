package com.example.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        log.error("Invalid arguments {}", exception.getBindingResult().getFieldErrors());
        String errorMessage = Objects.requireNonNull(exception.getFieldError()).getDefaultMessage();

        return new ResponseEntity<>(errorMessage,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        log.error(exception.getMessage());

        return new ResponseEntity<>(exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        log.error(exception.getMessage());

        return new ResponseEntity<>(exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }
}
