package com.example.auction.Exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidInputException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
