package com.spring.mapper;


import com.spring.entity.UserPropertyDO;

import java.sql.SQLException;

/**
 * dao - user property
 * <p>
 * 1. 插入数据
 * 2. 查询数据
 *
 * @auther ten
 */
public interface UserPropertyMapper {
    /**
     * 资料插入 :
     * 用户注册时启动
     * 插入UserPropertyDO到user_property表
     *
     * @param userPropertyDO userPropertyDO
     */
    void insertUserProperty(UserPropertyDO userPropertyDO);

    /**
     * 资料更新 :
     * 更新user_property表
     *
     * @param userPropertyDO userPropertyDO
     */
    void updateUserProperty(UserPropertyDO userPropertyDO);

    /**
     * 资料查询 :
     * 通过user_id进行查询
     * 获取数据库user_property信息
     * 信息封装在UserPropertyDO中返回
     *
     * @param userId 用户ID
     * @return UserPropertyDO UserPropertyDO
     * @throws NullPointerException 记录不存在
     */
    UserPropertyDO queryUserPropertyById(Integer userId);
}
