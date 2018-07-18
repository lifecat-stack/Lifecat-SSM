package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private String ERROR_MSG;

    private int userId;

    public UserNotFoundException() {
        ERROR_MSG = "User List not found";
    }

    public UserNotFoundException(int userId) {
        this.userId = userId;
        ERROR_MSG = "User not found by userId : " + userId;
    }

    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
