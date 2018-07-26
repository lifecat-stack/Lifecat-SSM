package com.spring.controller;

import com.spring.exception.ErrorInfo;
import com.spring.exception.RequestException;
import com.spring.exception.impl.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Controller
 *
 * @author Administrator
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * 请求出错 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({
            RequestDataNullException.class,
            RequestDataFormatException.class})
    public ErrorInfo requestError(RequestException e) {
        return new ErrorInfo(400, e.getErrorMsg());
    }

    /**
     * 查询失败 not found 404
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorInfo resourceNotFoundError(ResourceNotFoundException e) {
        return new ErrorInfo(404, e.getErrorMsg());
    }

    /**
     * 增加、修改、删除失败 conflict 409
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(ResourceExecuteException.class)
    public ErrorInfo resourceExecuteError(ResourceExecuteException e) {
        return new ErrorInfo(409, e.getErrorMsg());
    }
}
