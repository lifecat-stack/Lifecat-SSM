package com.spring.exception.impl;

import com.spring.exception.ResourceNotFoundException;

public class AdminNotFoundException extends RuntimeException implements ResourceNotFoundException {

    private String ERROR_MSG;

    private int adminId;

    public AdminNotFoundException() {
        System.out.println("resource not found exception");

        ERROR_MSG = "您没有权限访问";
    }

    public AdminNotFoundException(int adminId) {
        System.out.println("resource not found exception");

        this.adminId = adminId;
        ERROR_MSG = "Admin not found by adminId : " + adminId;
    }

    @Override
    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
