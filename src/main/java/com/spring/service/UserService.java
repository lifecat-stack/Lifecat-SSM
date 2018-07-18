package com.spring.service;

import com.spring.entity.UserDO;

import java.util.List;

/**
 * User
 *
 * @date 2018/7/17
 * @auther ten
 */
public interface UserService {
    /**
     * 获取所有user信息
     */
    List<UserDO> getUserList();

    /**
     * 获取user信息
     *
     * @param userId 用户ID
     */
    UserDO getUserById(int userId);

    /**
     * 创建user信息
     *
     * @param userDO 用户DO
     */
    String  postUser(UserDO userDO);

    /**
     * 更新user信息
     *
     * @param userDO 用户DO
     */
    String  putUser(UserDO userDO);

    /**
     * 删除user信息
     *
     * @param userId 用户ID
     */
    String  deleteUserById(int userId);
}