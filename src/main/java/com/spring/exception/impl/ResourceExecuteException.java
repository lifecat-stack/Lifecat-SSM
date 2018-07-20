package com.spring.exception.impl;

public class ResourceExecuteException extends RuntimeException{

    private String errorMsg;

    public ResourceExecuteException() {
        this.errorMsg = "resource execute failure";
    }

    public ResourceExecuteException(String errorMsg) {
        this.errorMsg = "resource execute failure : " + errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
