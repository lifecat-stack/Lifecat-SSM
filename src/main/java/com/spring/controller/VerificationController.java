package com.spring.controller;

import com.spring.jms.AlertMessage;
import com.spring.jms.impl.AlertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/verify")
public class VerificationController {

    private final AlertServiceImpl userAlertService;

    @Autowired
    public VerificationController(AlertServiceImpl userAlertService) {
        this.userAlertService = userAlertService;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String userLogin() {
        System.out.println("user login verification");
        // verify
        // TODO
        // success: send message
        AlertMessage message = new AlertMessage("user login success");
        userAlertService.sendLoginAlert(message);
        return "home";
    }
}
