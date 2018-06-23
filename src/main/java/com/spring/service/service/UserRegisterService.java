package com.spring.service.service;


import com.spring.entity.UserDO;
import com.spring.service.Service;

/**
 * 用户注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserRegisterService extends Service {

    boolean isUserExisted(String userName);

    void insertUserToDatabase(UserDO userDO);
}