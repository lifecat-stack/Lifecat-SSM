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

    @Autowired
    private DiaryMapper diaryMapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        System.out.println("home");
        return "home";
    }

    @RequestMapping(value = "/userhome", method = RequestMethod.GET)
    public String userhome() {
        return "userhome";
    }


}
