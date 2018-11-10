package com.ten.controller;

import com.ten.exception.RequestException;
import com.ten.exception.impl.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResultModel requestError(RequestException e) {
        return new ResultModel(400, e.getErrorMsg());
    }

    /**
     * 查询失败 not found 404
     */
    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResultModel resourceNotFoundError(ResourceNotFoundException e) {
        return new ResultModel(404, e.getErrorMsg());
    }

    /**
     * 增加、修改、删除失败 conflict 409
     */
    @ResponseBody
    @ExceptionHandler(ResourceExecuteException.class)
    public ResultModel resourceExecuteError(ResourceExecuteException e) {
        return new ResultModel(409, e.getErrorMsg());
    }
}
