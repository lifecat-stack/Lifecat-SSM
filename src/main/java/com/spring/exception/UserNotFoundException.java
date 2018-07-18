package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private String ERROR_MSG;

    private String userName;

    public UserNotFoundException() {
        ERROR_MSG = "User List not found";
    }

    public UserNotFoundException(String userName) {
        this.userName = userName;
        ERROR_MSG = "User not found by userName : " + userName;
    }

    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
