package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.Admin;
import com.ten.service.AdminService;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ten.util.ControllerCheckUtil.*;

@RestController
@RequestMapping("/admin/v1")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultModel getAdminList() {
        List<Admin> admins = adminService.readAdminList();
        return new ResultModel(ResponseCode.OK, admins);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postAdmin(@RequestBody @NotNull Admin admin) {
        Integer result = adminService.createAdmin(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, admin);
        }
        return new ResultModel(ResponseCode.OK, admin);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putAdmin(@RequestBody @NotNull Admin admin) {
        // check
        checkRequestDataNotNull(admin);
        // execute
        // TODO
        // return
        return new ResultModel("admin update is todo");
    }

    @RequestMapping(value = "/{adminId}", method = RequestMethod.DELETE)
    public ResultModel deleteAdmin(@PathVariable @NotNull String adminId) {
        // check
        checkRequestDataNotNull(adminId);
        checkRquestDataFormatInt(adminId);
        // execute
        // TODO
        // return
        return new ResultModel("admin delete is todo");
    }

}
