package com.ten.lifecat.ssm.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home-tap")
public class TapController {
    private static final Logger logger = LoggerFactory.getLogger(TapController.class);

    /**
     * main-tap
     */
    @RequestMapping(value = "/main")
    public String main() {
        return "home-tap/main";
    }

    /**
     * admin-tap
     */
    @RequestMapping(value = "/admin")
    public String admin() {
        return "home-tap/admin";
    }

    /**
     * user-tap
     */
    @RequestMapping(value = "/user")
    public String user() {
        return "home-tap/user";
    }

    /**
     * diary-tap
     */
    @RequestMapping(value = "/diary")
    public String diary() {
        return "home-tap/diary";
    }

    /**
     * image-tap
     */
    @RequestMapping(value = "/image")
    public String image() {
        return "home-tap/image";
    }
}
