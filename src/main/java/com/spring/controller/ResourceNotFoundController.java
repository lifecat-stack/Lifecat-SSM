package com.spring.controller;

import com.spring.exception.*;
import com.spring.exception.impl.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.spring.exception.Error;

@ControllerAdvice
public class ResourceNotFoundController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler({
            AdminNotFoundException.class,
            DiaryNotFoundException.class,
            ImageNotFoundException.class,
            UserNotFoundException.class,
            ServiceNotFoundException.class})
    public Error handleNotFound(ResourceNotFoundException e) {
        return new Error(e.getErrorMsg());
    }
}
