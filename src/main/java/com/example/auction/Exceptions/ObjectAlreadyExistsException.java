package com.example.auction.Exceptions;

public class ObjectAlreadyExistsException extends RuntimeException {

    public ObjectAlreadyExistsException() {
    }

    public ObjectAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

    public ObjectAlreadyExistsException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
