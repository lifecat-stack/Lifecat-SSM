package com.ten.lifecat.ssm.util;

import com.ten.lifecat.ssm.exception.impl.RequestDataFormatException;
import com.ten.lifecat.ssm.exception.impl.RequestDataNullException;
import org.springframework.stereotype.Component;

/**
 * Utils
 *
 * @author wshten
 * @date 2018/11/10
 */
@Component
public class ParamUtil {
    private static final ParamUtil INSTANCE = new ParamUtil();

    private ParamUtil() {
    }

    public static ParamUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Null ?
     */
    public void isParamNull(Object... objs) {
        for (Object obj : objs) {
            if (obj == null) {
                throw new RequestDataNullException();
            }
        }
    }

    /**
     * Not Null ?
     */
    public void isParamNotNull(Object... objs) {
        for (Object obj : objs) {
            if (obj != null) {
                throw new RequestDataNullException();
            }
        }
    }

    /**
     * Format is Int ?
     */
    public void isFormatInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RequestDataFormatException("param must be number");
        }
    }

}
