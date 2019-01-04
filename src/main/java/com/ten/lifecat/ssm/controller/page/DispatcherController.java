package com.ten.lifecat.ssm.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DispatcherController {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherController.class);

    /**
     * index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * home
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    /**
     * error
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String userror() {
        return "error";
    }

    /**
     * exception
     */
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() {
        return "exception";
    }
}
