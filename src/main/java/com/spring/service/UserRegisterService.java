package com.spring.service;


import com.spring.entity.UserDO;

/**
 * 用户注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserRegisterService{

    boolean isUserExisted(String userName);

    void insertUserToDatabase(UserDO userDO);
}