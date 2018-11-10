package com.ten.service;

import com.ten.entity.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 获取所有admin信息
     */
    List<Admin> readAdminList();

    /**
     * 获取admin信息
     *
     * @param adminName admin_name
     */
    Admin readAdminByName(String adminName);

    /**
     * 创建admin信息
     *
     * @param admin DO
     */
    int createAdmin(Admin admin);

    /**
     * 更新admin信息
     *
     * @param admin DO
     */
    int updateAdmin(Admin admin);

    /**
     * 删除admin信息
     *
     * @param adminId admin_id
     */
    int deleteAdminById(int adminId);
}
