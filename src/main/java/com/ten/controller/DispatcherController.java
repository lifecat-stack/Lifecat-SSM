package com.ten.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 主视图控制器
 *
 * @author Administrator
 */
@Controller
public class DispatcherController {

    private Logger logger = LoggerFactory.getLogger(DispatcherController.class);

    /**
     * index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        logger.info("request to index");
        return "index";
    }

    /**
     * home
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        logger.info("request to home");
        return "home";
    }

    /**
     * error
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String userror() {
        logger.info("request to error");
        return "error";
    }

    /**
     * exception
     */
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() {
        logger.info("request to exception");
        return "exception";
    }
}
