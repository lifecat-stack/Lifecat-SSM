package com.ten.annotation;

import java.lang.annotation.*;

/**
 * LOG AOP
 *
 * @author wshten
 * @date 2018/11/10
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InvokeLog {
    /**
     * Method Name
     */
    String method() default "";
}
