package com.spring.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInfoInterceptor {

    private Logger logger = LoggerFactory.getLogger(ControllerInfoInterceptor.class);

    @Pointcut("execution(public * com.spring.controller.UserController.*(..))")
    public void infoToken(){}

    @Before("infoToken()")
    public void beforeInfoToken(){
        System.out.println("controller execute before");
        logger.info("controller execute before");
    }

    @After("infoToken()")
    public void afterInfoToken(){
        System.out.println("controller execute before");
        logger.info("controller execute before");
    }

    @AfterThrowing
    public void afterThrowing(){
        logger.warn("controller execute exception");
    }
}
