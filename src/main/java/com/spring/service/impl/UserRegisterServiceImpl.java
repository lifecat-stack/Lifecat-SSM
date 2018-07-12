package com.spring.service.impl;

import com.spring.entity.UserDO;
import com.spring.service.UserRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 用户注册
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userRegisterService")
public class UserRegisterServiceImpl implements UserRegisterService {

    private Logger logger = LoggerFactory.getLogger(UserRegisterServiceImpl.class);

    @Override
    public boolean isUserExisted(String userName) {
        return false;
    }

    @Override
    public void insertUserToDatabase(UserDO userDO) {

    }
}