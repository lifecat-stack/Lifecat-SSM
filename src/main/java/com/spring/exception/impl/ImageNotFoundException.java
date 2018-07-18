package com.spring.exception.impl;

import com.spring.exception.ResourceNotFoundException;

public class ImageNotFoundException extends RuntimeException implements ResourceNotFoundException {

    private String ERROR_MSG;

    private String imageName;
    private int userId;
    private int classId;

    public ImageNotFoundException(String imageName) {
        System.out.println("resource not found exception");

        this.imageName = imageName;
        ERROR_MSG = "Image not found by imageName : " + imageName;
    }

    public ImageNotFoundException(int userId) {
        System.out.println("resource not found exception");

        this.userId = userId;
        ERROR_MSG = "Image List not found by userId : " + userId;
    }

    public ImageNotFoundException(int userId, int classId) {
        System.out.println("resource not found exception");

        this.userId = userId;
        this.classId = classId;
        ERROR_MSG = "Image Class List not found by userId : " + userId + " and classId : " + classId;
    }


    @Override
    public String getErrorMsg() {
        return ERROR_MSG;
    }
}
