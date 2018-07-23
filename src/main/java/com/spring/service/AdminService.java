package com.spring.service;

import com.spring.entity.AdminDO;

import java.util.List;

public interface AdminService {
    /**
     * 获取所有admin信息
     */
    List<AdminDO> readAdminList();

    /**
     * 获取admin信息
     *
     * @param adminName admin_name
     */
    AdminDO readAdminByName(String adminName);

    /**
     * 创建admin信息
     *
     * @param adminDO DO
     */
    int createAdmin(AdminDO adminDO);

    /**
     * 更新admin信息
     *
     * @param adminDO DO
     */
    int updateAdmin(AdminDO adminDO);

    /**
     * 删除admin信息
     *
     * @param adminId admin_id
     */
    int deleteAdminById(int adminId);
}
