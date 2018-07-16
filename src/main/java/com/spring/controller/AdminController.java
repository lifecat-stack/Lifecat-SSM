package com.spring.controller;

import com.spring.service.AdminLoginService;
import com.spring.service.AdminRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/v1")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private AdminRegisterService adminRegisterService;

    /**
     * admin login
     */
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("adminName") String adminName,
                             @RequestParam("adminPassword") String adminPassword) {
        logger.debug("admin login");
        assert adminName != null;
        assert adminPassword != null;
        boolean success = adminLoginService.adminLogin(adminName, adminPassword);
        if (success) {
            return "home";
        } else {
            return "login";
        }
    }

    /**
     * admin register
     */
    @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
    public String adminRegister(@RequestParam("adminName") String adminName,
                                @RequestParam("adminPassword") String adminPassword) {
        logger.debug("admin register");
        assert adminName != null;
        assert adminPassword != null;
        boolean success = adminRegisterService.adminRegister(adminName, adminPassword);
        if (success) {
            return "home";
        } else {
            return "login";
        }
    }
}
