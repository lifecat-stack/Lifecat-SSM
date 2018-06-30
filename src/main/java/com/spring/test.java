package com.spring;

import com.spring.service.UserLoginService;
import com.spring.service.impl.UserLoginServiceImpl;

public class test {
    public static void main(String[] args) {
        UserLoginService service = new UserLoginServiceImpl();
        service.isUserExisted("test");

    }
}
