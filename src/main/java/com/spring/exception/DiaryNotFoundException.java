package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiaryNotFoundException extends RuntimeException {

    private String ERROR_MSG;

    private String diaryName;
    private int userId;

    public DiaryNotFoundException(String diaryName) {
        this.diaryName = diaryName;
        ERROR_MSG = "Diary not found by diaryName : " + diaryName;
    }

    public DiaryNotFoundException(int userId) {
        this.userId = userId;
        ERROR_MSG = "Diary List not found by userId : " + userId;
    }

    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
