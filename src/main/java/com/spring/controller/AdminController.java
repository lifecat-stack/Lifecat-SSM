package com.spring.controller;

import com.spring.exception.impl.AdminNotFoundException;
import com.spring.exception.impl.ServiceNotLoaderException;
import com.spring.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/v1")
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
        if (this.adminService == null){
            throw new ServiceNotLoaderException(adminService.getClass().getName());
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAdmin() {
        throw new AdminNotFoundException();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postAdmin() {
       throw new AdminNotFoundException();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String putAdmin() {
        throw new AdminNotFoundException();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteAdmin() {
        throw new AdminNotFoundException();
    }

}
