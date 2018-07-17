package com.spring.controller;

import com.spring.mapper.DiaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DispatcherController {

    private static Logger logger = LoggerFactory.getLogger(DispatcherController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        logger.debug("index requeset");
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        logger.debug("home request");
        return "home";
    }

    @RequestMapping(value = "/userror", method = RequestMethod.GET)
    public String userror() {
        logger.debug("userror request");
        return "userror";
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() {
        logger.debug("exception request");
        return "exception";
    }
}
