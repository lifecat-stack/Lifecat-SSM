package com.ten.lifecat.ssm.util;

import com.ten.lifecat.ssm.exception.impl.RequestDataNullException;
import org.springframework.stereotype.Component;

/**
 * Check service function and throwing exception to the ExceptionController
 *
 * @author Administrator
 */
@Component
public class ServiceCheckUtil {
    /**
     * 检查传入对象的参数 Null
     *
     * @param property request parameter property
     * @throws RequestDataNullException request parameter property is null
     */
    public static void checkObjectDataNotNull(Object property) {
        if (property == null) {
            throw new RequestDataNullException();
        }
    }
}
