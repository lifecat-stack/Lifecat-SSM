package com.spring.controller;

import com.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/v1")
public class UserController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserPswUpdateService userPswUpdateService;
    @Autowired
    private UserPropertyUpdateService userPropertyUpdateService;
    @Autowired
    private UserPropertyQueryService userPropertyQueryService;
    @Autowired
    private UserIconUpdateService userIconUpdateService;

    @RequestMapping("/user_login")
    public ModelAndView userLogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/user_register")
    public ModelAndView userRegister() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/user_password_update")
    public ModelAndView userPasswordUpdate() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/user_property_update")
    public ModelAndView userPropertyUpdate() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/user_icon_update")
    public ModelAndView userIconUpdate() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/user_property_query")
    public ModelAndView userPropertyQuery() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

}
