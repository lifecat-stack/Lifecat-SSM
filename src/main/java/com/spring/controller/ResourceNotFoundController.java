package com.spring.controller;

import com.spring.exception.*;
import com.spring.exception.impl.AdminNotFoundException;
import com.spring.exception.impl.DiaryNotFoundException;
import com.spring.exception.impl.ImageNotFoundException;
import com.spring.exception.impl.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.Error;

@ControllerAdvice
public class ResourceNotFoundController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler({
            AdminNotFoundException.class,
            DiaryNotFoundException.class,
            ImageNotFoundException.class,
            UserNotFoundException.class})
    public Error handleNotFound(ResourceNotFoundException e) {
        return new Error(e.getErrorMsg());
    }
}
