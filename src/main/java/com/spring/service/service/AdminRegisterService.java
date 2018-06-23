package com.spring.service.service;


import com.spring.entity.AdminDO;
import com.spring.service.Service;

/**
 * 管理员注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface AdminRegisterService extends Service {
    /**
     * 查询账号是否存在
     *
     * @param
     * @throws
     */
    boolean isAdminExisted(String adminName);

    /**
     * 向数据库注册账号
     *
     * @param
     * @throws
     */
    void insertAdminToDatabase(AdminDO adminDO);
}
