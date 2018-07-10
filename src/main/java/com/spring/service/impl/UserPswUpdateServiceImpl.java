package com.spring.service.impl;

import com.spring.entity.UserDO;
import com.spring.service.UserPswUpdateService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 更新用户密码
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userPswUpdateServiceImpl")
public class UserPswUpdateServiceImpl implements UserPswUpdateService {

    private Logger logger = LoggerFactory.getLogger(UserPswUpdateServiceImpl.class);


    @Override
    public void updateUserPassword(UserDO userDO) {

    }
}

