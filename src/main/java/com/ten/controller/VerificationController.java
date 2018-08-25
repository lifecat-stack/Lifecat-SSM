package com.ten.controller;

import com.ten.entity.AdminDO;
import com.ten.jms.AlertMessage;
import com.ten.jms.AlertService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * shiro验证控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/verify")
public class VerificationController {

    private static final Logger logger = LoggerFactory.getLogger(VerificationController.class);

    /**
     * admin login
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLogin(@RequestBody AdminDO adminDO) {
        System.out.println("admin login verification");
        ModelAndView mv = new ModelAndView();
        String adminName = adminDO.getAdminName();
        String adminPassword = adminDO.getAdminPassword();
        // verify
        UsernamePasswordToken token = new UsernamePasswordToken(adminName, adminPassword);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            // success: send message
            AlertMessage message = new AlertMessage("admin login success");
//            userAlertService.sendLoginAlert(message);
            mv.addObject("admin", adminDO);
            mv.setViewName("home");
            return mv;
        } catch (Exception e) {
            mv.setViewName("index");
            return mv;
        }
    }
}
