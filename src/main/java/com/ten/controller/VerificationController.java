package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.Admin;
import com.ten.jms.AlertMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel adminLogin(@RequestParam String name,
                                  @RequestParam String password) {
        logger.info("Admin Login:{},{}", name, password);
        Admin admin = new Admin();
        admin.setAdminName(name);
        admin.setAdminPassword(password);

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new ResultModel(ResponseCode.OK, admin);
        } catch (Exception e) {
            return new ResultModel(ResponseCode.LOGIN_ERROR, admin);
        }
    }
}
