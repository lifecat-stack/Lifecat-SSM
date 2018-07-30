package com.spring.controller;

import com.spring.dto.ResponseResult;
import com.spring.entity.AdminDO;
import com.spring.service.AdminService;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.spring.util.ControllerCheckUtil.*;

/**
 * admin rest
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/admin/v1")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
        checkResourceNotNull(adminService, "adminService not load");
    }

    /**
     * 查询admin list
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseResult getAdminList() {
        // execute

        // return

        return new ResponseResult("admin list is null");
    }

    /**
     * 创建admin
     *
     * @param adminDO admin
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseResult postAdmin(@RequestBody AdminDO adminDO) {
        // check
        checkRequestDataNotNull(adminDO);
        // execute
        // TODO
        // return
        return new ResponseResult("admin create is todo");
    }

    /**
     * 更新admin
     *
     * @param adminDO admin
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseResult putAdmin(@RequestBody @NotNull AdminDO adminDO) {
        // check
        checkRequestDataNotNull(adminDO);
        // execute
        // TODO
        // return
        return new ResponseResult("admin update is todo");
    }

    /**
     * 删除admin
     *
     * @param adminId admin_id
     */
    @RequestMapping(value = "/{adminId}", method = RequestMethod.DELETE)
    public ResponseResult deleteAdmin(@PathVariable @NotNull String adminId) {
        // check
        checkRequestDataNotNull(adminId);
        checkRquestDataFormatInt(adminId);
        // execute
        // TODO
        // return
        return new ResponseResult("admin delete is todo");
    }

}
