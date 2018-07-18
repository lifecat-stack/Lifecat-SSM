package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends RuntimeException {

    private String ERROR_MSG;

    private int adminId;

    public AdminNotFoundException(int adminId) {
        System.out.println("resource not found exception");

        this.adminId = adminId;
        ERROR_MSG = "Admin not found by adminId : " + adminId;
    }

    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
