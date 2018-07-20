package com.spring.exception;

public class RequestError {

    private String message;

    public RequestError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
