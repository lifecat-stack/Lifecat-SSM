package com.ten.controller;

import com.ten.entity.Admin;
import com.ten.jms.AlertMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin Login
 *
 * @author wshten
 * @date 2018/11/10
 */
@Controller
@RequestMapping(value = "/login")
public class VerificationController {
    private static final Logger logger = LoggerFactory.getLogger(VerificationController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView adminLogin(@RequestParam String name,
                                   @RequestParam String password) {
        logger.info("Admin Login:{},{}", name, password);
        Admin admin = new Admin();
        admin.setAdminName(name);
        admin.setAdminPassword(password);

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        ModelAndView mv = new ModelAndView();
        try {
            subject.login(token);
            mv.addObject("admin", admin);
            mv.setViewName("home");
            return mv;
        } catch (Exception e) {
            mv.setViewName("index");
            return mv;
        }
    }
}
