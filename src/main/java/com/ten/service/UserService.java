package com.ten.service;

import com.ten.entity.User;

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
    List<User> readUserList();

    /**
     * 获取user信息
     *
     * @param userName user_name
     */
    User readUserByName(String userName);

    /**
     * 创建user信息
     *
     * @param user DO
     */
    int createUser(User user);

    /**
     * 更新user信息
     *
     * @param user DO
     */
    int updateUser(User user);

    /**
     * 删除user信息
     *
     * @param userId user_id
     */
    int deleteUserById(int userId);
}