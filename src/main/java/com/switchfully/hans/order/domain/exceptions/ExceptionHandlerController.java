package com.switchfully.hans.order.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private final Logger myLogger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(NotAnAdminException.class)
    protected ResponseEntity<Object> handleAdminIdNotFound(
            NotAnAdminException ex) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        myLogger.warn(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(CreationFailedException.class)
    protected ResponseEntity<Object> CreationFailed(
            CreationFailedException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage("itemId not found in store");
        myLogger.warn(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleAdminIdNotFound(
            EntityNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        myLogger.warn(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(NotACustomerException.class)
    protected ResponseEntity<Object> handleAdminIdNotFound(
            NotACustomerException ex) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        myLogger.warn(ex.getMessage());
        return buildResponseEntity(apiError);
    }



    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

