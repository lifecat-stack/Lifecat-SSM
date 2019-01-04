package com.ten.lifecat.ssm.service;

import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.entity.Admin;
import com.ten.lifecat.ssm.mapper.AdminDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.rmi.server.RMIClassLoader;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public int insert(Admin pojo) {
        return adminDao.insert(pojo);
    }

    public int insertList(List<Admin> pojos) {
        return adminDao.insertList(pojos);
    }

    public List<Admin> select(Admin pojo) {
        return adminDao.select(pojo);
    }

    public int update(Admin pojo) {
        return adminDao.update(pojo);
    }

    public int delete(Admin pojo) {
        return adminDao.delete(pojo);
    }

    /**
     * 管理员登录与授权
     *
     * @param session 登录信息保存在session中
     */
    public ResultModel login(HttpSession session, Admin admin) {
        String password = admin.getAdminPassword();

        admin.setAdminPassword(null);

        List<Admin> adminList = adminDao.select(admin);

        // 用户名不存在
        if (adminList.size() < 1) {
            return ResultModel.error("用户名错误！");
        }

        Admin entity = adminList.get(0);

        // 账户被禁用
        if (entity.getIsDeleted() == 1) {
            return ResultModel.error("当前用户不可用！");
        }

        // 密码错误
        if (!password.equals(entity.getAdminPassword())) {
            return ResultModel.error("密码错误！");
        }

        System.out.println("theLoginAdmin:" + entity);

        // 登录成功，设置session信息
        session.setAttribute("theLoginAdmin", entity);
        session.setAttribute("theLoginRole", "admin");

        return ResultModel.ok("登录成功");
    }
}
