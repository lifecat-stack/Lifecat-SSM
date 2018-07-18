package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiaryNotFoundException extends RuntimeException {
    private static final String ERROR_MSG = "Diary not found";

    private Integer diaryId;

    public DiaryNotFoundException(int diaryId) {
        this.diaryId = diaryId;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public static String getErrorMsg() {
        return ERROR_MSG;
    }
}
