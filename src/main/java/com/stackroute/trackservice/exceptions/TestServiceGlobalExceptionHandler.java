package com.stackroute.trackservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception handler class which handles TrackNotFoundException, TrackAlreadyExistsException
 */
@ControllerAdvice
public class TestServiceGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<?> handleTrackAlreadyExistsExceptions(TrackAlreadyExistsException trackAlreadyExistsException, WebRequest request) {
        String message = "Track already exists in Database.";
        return handleExceptionInternal(trackAlreadyExistsException, message, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> handleTrackNotFoundException(TrackNotFoundException trackNotFoundException, WebRequest request) {
        String message = "Track not found in database.";
        return handleExceptionInternal(trackNotFoundException, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

    }
}
