package com.ten.lifecat.ssm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * shiro验证控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/login")
public class VerificationController {

    private static final Logger logger = LoggerFactory.getLogger(VerificationController.class);

    /**
     * admin login
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult adminLogin(@RequestBody AdminDO adminDO) {
        System.out.println("admin login verification");
        String adminName = adminDO.getAdminName();
        String adminPassword = adminDO.getAdminPassword();
        // verify
        UsernamePasswordToken token = new UsernamePasswordToken(adminName, adminPassword);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new ResponseResult();
        } catch (Exception e) {
            return new ResponseResult("登录失败");
        }
    }
}
