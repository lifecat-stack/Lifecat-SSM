package com.ten.util;

import com.ten.exception.impl.RequestDataFormatException;
import com.ten.exception.impl.RequestDataNullException;
import com.ten.exception.impl.ResourceExecuteException;
import com.ten.exception.impl.ResourceNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Check controller function and throwing exception to the ExceptionController
 *
 * @author Administrator
 */
@Component
public class ControllerCheckUtil {
    /**
     * 检查请求参数 Null
     *
     * @param obj request parameter
     * @throws RequestDataNullException request data is null
     */
    public static void checkRequestDataNotNull(Object obj) {
        if (obj == null) {
            throw new RequestDataNullException();
        }
    }

    /**
     * 检查请求参数为 int Format
     *
     * @param string 待检查String
     * @throws RequestDataFormatException string data is not number
     */
    public static void checkRquestDataFormatInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RequestDataFormatException("Id must be number");
        }
    }

    /**
     * 检查返回结果 result = 0 is failure
     *
     * @param result SQL执行影响的行数
     */
    public static void checkExecuteResultSuccess(int result) {
        if (result < 1) {
            throw new ResourceExecuteException("execute failure");
        }
    }

    /**
     * 检查资源 1
     *
     * @param resource 资源对象
     */
    public static void checkResourceNotNull(Object resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * 检查资源 2
     *
     * @param resource 资源对象
     * @param errorMsg 异常信息
     */
    public static void checkResourceNotNull(Object resource, String errorMsg) {
        if (resource == null) {
            throw new ResourceNotFoundException(errorMsg);
        }
    }

}
