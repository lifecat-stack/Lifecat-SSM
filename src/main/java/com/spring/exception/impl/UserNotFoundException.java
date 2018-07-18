package com.spring.exception.impl;

import com.spring.exception.ResourceNotFoundException;

public class UserNotFoundException extends RuntimeException implements ResourceNotFoundException {

    private String ERROR_MSG;

    private String userName;

    public UserNotFoundException() {
        System.out.println("resource not found exception");

        ERROR_MSG = "User List not found";
    }

    public UserNotFoundException(String userName) {
        System.out.println("resource not found exception");

        this.userName = userName;
        ERROR_MSG = "User not found by userName : " + userName;
    }

    @Override
    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
