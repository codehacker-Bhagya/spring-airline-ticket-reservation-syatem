package com.bhagya.practice.Exception;

public class InvalidUidException extends RuntimeException {
    public InvalidUidException(String message) {
        super(message);
    }
}
