package com.spring.exception.impl;

import com.spring.exception.RequestException;

public class RequestDataFormatException extends RuntimeException implements RequestException {

    private String errorMsg;

    public RequestDataFormatException() {
        this.errorMsg = "request's data is null";
    }

    public RequestDataFormatException(String errorMsg) {
        this.errorMsg = "request data format error : " + errorMsg;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}