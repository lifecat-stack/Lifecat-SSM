package com.ten.exception.impl;

public class ResourceNotFoundException extends RuntimeException {

    private String errorMsg;

    public ResourceNotFoundException() {
        this.errorMsg = "resource not found exception";
    }

    public ResourceNotFoundException(String msg) {
        this.errorMsg = "resource not found exception : " + msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
