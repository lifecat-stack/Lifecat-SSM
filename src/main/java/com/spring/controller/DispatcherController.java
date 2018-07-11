package com.spring.controller;

import com.spring.service.AdminLoginService;
import com.spring.service.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DispatcherController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/userhome", method = RequestMethod.GET)
    public String userhome() {
        return "userhome";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "forward:/admin";
    }

    @RequestMapping(value = "/user")
    public String user(){
        return "forward:/user";
    }

    @RequestMapping(value = "/diary")
    public String diary(){
        return "forward:/diary";
    }

    @RequestMapping(value = "/image")
    public String image(){
        return "forward:/image";
    }

}
