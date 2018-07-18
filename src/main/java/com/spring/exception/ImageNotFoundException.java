package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImageNotFoundException extends RuntimeException {

    private String ERROR_MSG;

    private String imageName;
    private int userId;
    private int classId;

    public ImageNotFoundException(String imageName) {
        this.imageName = imageName;
        ERROR_MSG = "Image not found by imageName : " + imageName;
    }

    public ImageNotFoundException(int userId) {
        this.userId = userId;
        ERROR_MSG = "Image List not found by userId : " + userId;
    }

    public ImageNotFoundException(int userId, int classId) {
        this.userId = userId;
        this.classId = classId;
        ERROR_MSG = "Image Class List not found by userId : " + userId + " and classId : " + classId;
    }


    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
