package com.ten.lifecat.ssm.exception.impl;

import com.ten.lifecat.ssm.exception.RequestException;

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
