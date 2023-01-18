package com.example.auction.Exceptions;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException() {
    }

    public IdNotFoundException(String errorMessage) {

        super(errorMessage);

    }

    public IdNotFoundException(String errorMessage, Throwable err) {

        super(errorMessage, err);

    }
}