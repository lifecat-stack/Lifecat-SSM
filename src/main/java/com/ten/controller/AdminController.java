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
        List<Admin> admins = adminService.readAdminList();
        if (admins.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员查询失败");
        }
        return new ResultModel(ResponseCode.OK, admins);
    }

    /**
     * Create Admin
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postAdmin(@RequestBody @NotNull Admin admin) {
        Integer result = adminService.createAdmin(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员创建失败:" + admin);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update Admin
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putAdmin(@RequestBody @NotNull Admin admin) {
        Integer result = adminService.updateAdmin(admin);
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
        checkRquestDataFormatInt(adminId);
        Integer result = adminService.deleteAdminById(Integer.parseInt(adminId));
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员删除失败:" + adminId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

}
