package com.switchfully.hans.order.domain.exceptions;

public class OrderNotFoundException extends RuntimeException {
    String message;

    public OrderNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Order with id " + message + " was not found in the Oerder shop";
    }
}
