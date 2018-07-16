package com.spring.controller;

import com.spring.entity.DiaryDO;
import com.spring.mapper.DiaryMapper;
import com.spring.service.AdminLoginService;
import com.spring.service.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DispatcherController {

    @Autowired
    private DiaryMapper diaryMapper;

    /**
     * 测试home-tap的获取
     */
    @RequestMapping(value = "/home-tap/main")
    public String resource() {
        System.out.println("resoutce");
        return "home-tap/main";
    }

    /**
     * 测试ajax获取html
     */
    @RequestMapping(value = "/ajaxHtml")
    public String ajax() {
        System.out.println("ajax html");
        return "home-tap/main";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
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

    @RequestMapping(value = "/admin")
    public String admin() {
        return "forward:/admin";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "forward:/user";
    }

    @RequestMapping(value = "/diaries")
    public String diary() {
        return "forward:/diaries";
    }

    @RequestMapping(value = "/image")
    public String image() {
        return "forward:/image";
    }

}
