package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home-tap")
public class TapController {

    private static Logger logger = LoggerFactory.getLogger(TapController.class);

    @RequestMapping(value = "/main")
    public String main() {
        logger.debug("/home-tap/main request");
        return "home-tap/main";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        logger.debug("/home-tap/admin request");
        return "home-tap/admin";
    }

    @RequestMapping(value = "/user")
    public String user() {
        logger.debug("/home-tap/user request");
        return "home-tap/user";
    }

    @RequestMapping(value = "/diary")
    public String diary() {
        logger.debug("/home-tap/diary request");
        return "home-tap/diary";
    }

    @RequestMapping(value = "/image")
    public String image() {
        logger.debug("/home-tap/image request");
        return "home-tap/image";
    }
}
