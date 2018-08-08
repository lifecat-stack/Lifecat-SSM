package com.spring.controller;

import com.spring.dto.ResponseResult;
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
    @ResponseBody
    @ExceptionHandler({
            RequestDataNullException.class,
            RequestDataFormatException.class})
    public ResponseResult requestError(RequestException e) {
        return new ResponseResult(400, e.getErrorMsg());
    }

    /**
     * 查询失败 not found 404
     */
    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseResult resourceNotFoundError(ResourceNotFoundException e) {
        return new ResponseResult(404, e.getErrorMsg());
    }

    /**
     * 增加、修改、删除失败 conflict 409
     */
    @ResponseBody
    @ExceptionHandler(ResourceExecuteException.class)
    public ResponseResult resourceExecuteError(ResourceExecuteException e) {
        return new ResponseResult(409, e.getErrorMsg());
    }
}
