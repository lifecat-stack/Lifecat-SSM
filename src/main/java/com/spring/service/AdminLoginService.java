package com.spring.service;

import com.spring.entity.AdminDO;

/**
 * 管理员登录
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface AdminLoginService{
    boolean adminLogin(String adminName,String adminPassword);
    /**
     * 账号是否存在
     *
     * @param
     * @throws
     */
    boolean isAdminExisted(String adminName);

    /**
     * 获取账号信息
     *
     * @param
     * @throws
     */
    AdminDO queryAdminByName(String adminName);
}
