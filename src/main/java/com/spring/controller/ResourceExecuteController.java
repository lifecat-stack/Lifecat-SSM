package com.spring.controller;

import com.spring.exception.RequestError;
import com.spring.exception.impl.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 增加、修改、删除失败 conflict 409
 *
 * @author Administrator
 */
@ControllerAdvice
public class ResourceExecuteController {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(ResourceExecuteException.class)
    public RequestError handleExecute(ResourceExecuteException e) {
        return new RequestError(e.getErrorMsg());
    }
}
