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
    List<UserDO> readUserList();

    /**
     * 获取user信息
     *
     * @param userName user_name
     */
    UserDO readUserByName(String userName);

    /**
     * 创建user信息
     *
     * @param userDO DO
     */
    void createUser(UserDO userDO);

    /**
     * 更新user信息
     *
     * @param userDO DO
     */
    void updateUser(UserDO userDO);

    /**
     * 删除user信息
     *
     * @param userId user_id
     */
    void deleteUserById(int userId);
}