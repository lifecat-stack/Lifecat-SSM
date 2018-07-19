package com.spring.exception.impl;

import com.spring.exception.ResourceNotFoundException;

public class ServiceNotFoundException extends RuntimeException implements ResourceNotFoundException {

    private String ERROR_MSG;

    public ServiceNotFoundException(String serviceName) {
        this.ERROR_MSG = "Service not loader : " + serviceName;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
