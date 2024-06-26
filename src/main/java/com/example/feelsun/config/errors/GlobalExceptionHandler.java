package com.example.feelsun.config.errors;

import com.example.feelsun.config.errors.exception.*;
import com.example.feelsun.config.utils.ApiResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> badRequest(Exception400 exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.body());
    }

    @ExceptionHandler(Exception401.class)
    public ResponseEntity<?> unAuthorized(Exception401 exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.body());
    }

    @ExceptionHandler(Exception403.class)
    public ResponseEntity<?> forbidden(Exception403 exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.body());
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> notFound(Exception404 exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.body());
    }

    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> serverError(Exception500 exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.body());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unknownError(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponseBuilder.error(exception.getMessage()));
    }
}