package com.ten.lifecat.ssm.controller.data;

import com.ten.lifecat.ssm.dto.ResponseCode;
import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.entity.Admin;
import com.ten.lifecat.ssm.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController<Admin> {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private static final String LEVEL = "admin";

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理员登录与授权
     *
     * @param session 登录信息保存在session中
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultModel login(HttpSession session, @RequestBody Admin admin) {
        return adminService.login(session, admin);
    }

    @Override
    public ResultModel list(Admin admin) {
        admin.setIsDeleted(0);
        List<Admin> admins = adminService.select(admin);

        if (admins.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员列表查询失败" + admin);
        }
        return new ResultModel(ResponseCode.OK, admins);
    }

    @Override
    public ResultModel get(Admin admin) {
        admin.setIsDeleted(0);
        List<Admin> admins = adminService.select(admin);

        if (admins.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员查询失败" + admin);
        }
        return new ResultModel(ResponseCode.OK, admins.get(0));
    }

    @Override
    public ResultModel post(Admin admin) {
        String current = super.dateTimeUtil.getCurrentTime();

        admin.setAdminLevel(LEVEL)
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(NO_DELETED);

        Integer result = adminService.insert(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员创建失败:" + admin);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel update(Admin admin) {
        String current = super.dateTimeUtil.getCurrentTime();

        admin.setUpdateTime(current);

        Integer result = adminService.update(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员更新失败:" + admin);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel delete(Admin admin) {
        String current = super.dateTimeUtil.getCurrentTime();

        admin.setUpdateTime(current)
                .setIsDeleted(IS_DELETED);

        Integer result = adminService.update(admin);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "管理员删除失败:" + admin);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }
}
