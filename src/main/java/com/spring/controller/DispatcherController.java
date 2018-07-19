package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DispatcherController {

    private static Logger logger = LoggerFactory.getLogger(DispatcherController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        logger.info("request to index");
        return "error";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        logger.info("request to home");
        return "home";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String userror() {
        logger.info("request to error");
        return "error";
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() {
        logger.info("request to exception");
        return "exception";
    }
}
