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

    @ResponseBody
    @RequestMapping(value = "/ajaxGet", method = RequestMethod.GET)
    public List<DiaryDO> ajaxTest() {
        List<DiaryDO> diaryList = new ArrayList<DiaryDO>();
        System.out.println("ajax json controller get");
        for (int i = 0; i < 4; i++) {
            DiaryDO diaryDO = new DiaryDO();
            diaryDO.setDiaryId(i);
            diaryDO.setUserId(i);
            diaryDO.setDiaryName("json test diaryName" + i);
            diaryDO.setdiaryText("json test diaryText" + i);
            diaryDO.setdiaryGmtCreate("2018-01-01 00:00:00" + i);
            diaryDO.setdiaryGmtModified("2019-01-01 00:00:00" + i);
            diaryList.add(diaryDO);
        }

        return diaryList;
    }

    @ResponseBody
    @RequestMapping(value = "/mybatisGet", method = RequestMethod.GET)
    public List<DiaryDO> mybatisGet() {
        System.out.println("mybatis get");

        return diaryMapper.queryDiaryListByUserId(1);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
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

    @RequestMapping(value = "/diary")
    public String diary() {
        return "forward:/diary";
    }

    @RequestMapping(value = "/image")
    public String image() {
        return "forward:/image";
    }

}
