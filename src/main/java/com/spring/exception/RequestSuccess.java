package com.spring.exception;

public class RequestSuccess {

    private String message;

    public RequestSuccess(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return message;
    }
}
