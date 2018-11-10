package com.ten.annotation;

import java.lang.annotation.*;

/**
 * LOG AOP : When Method Invoked, Print It's Name
 *
 * @author wshten
 * @date 2018/11/10
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InvokeLog {

}
