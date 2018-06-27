package com.spring.service;


import com.spring.entity.UserDO;
import com.spring.service.util.Service;

/**
 * 更新用户密码
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPswUpdateService extends Service {
    void updateUserPassword(UserDO userDO);
}

