package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.Admin;
import com.ten.service.AdminService;
import com.sun.istack.internal.NotNull;
import com.ten.util.ControllerUtil;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin Controller
 *
 * @author wshten
 * @date 2018/11/10
 */
@RestController
@RequestMapping("/admin/v1")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private static final String SUCCESS = "SUCCESS";

    private ControllerUtil checkUtil = ControllerUtil.getInstance();
    private DateTimeUtil timeUtil = DateTimeUtil.getInstance();

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Get All Admin
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultModel getAdminList() {
        Admin admin = new Admin()
                .setIsDeleted(0);

        List<Admin> admins = adminService.select(admin);

        if (admins.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员查询失败");
        }
        return new ResultModel(ResponseCode.OK, admins);
    }

    /**
     * Create Admin
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postAdmin(@RequestParam @NotNull String adminName,
                                 @RequestParam @NotNull String adminPassword) {
        String current = timeUtil.getCurrentTime();

        Admin admin = new Admin()
                .setAdminName(adminName)
                .setAdminPassword(adminPassword)
                .setAdminLevel("admin")
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(0);

        Integer result = adminService.insert(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员创建失败:" + admin);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update Admin
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putAdmin(@RequestParam @NotNull String adminName,
                                @RequestParam @NotNull String adminPassword) {
        String current = timeUtil.getCurrentTime();

        Admin admin = new Admin()
                .setAdminName(adminName)
                .setAdminPassword(adminPassword)
                .setUpdateTime(current);

        Integer result = adminService.update(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员更新失败:" + admin);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Delete Admin By adminId
     */
    @RequestMapping(value = "/{adminId}", method = RequestMethod.DELETE)
    public ResultModel deleteAdmin(@PathVariable @NotNull String adminId) {
        checkUtil.isFormatInt(adminId);

        Admin admin = new Admin()
                .setId(Integer.valueOf(adminId))
                .setUpdateTime(timeUtil.getCurrentTime())
                .setIsDeleted(1);

        Integer result = adminService.update(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员删除失败:" + adminId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

}
