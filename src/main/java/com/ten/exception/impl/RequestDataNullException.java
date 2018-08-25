package com.ten.exception.impl;

import com.ten.exception.RequestException;

public class RequestDataNullException extends RuntimeException implements RequestException {

    private String errorMsg;

    public RequestDataNullException() {
        this.errorMsg = "request's data is null";
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
