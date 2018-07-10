package com.spring.service.impl;

import com.spring.entity.UserDO;
import com.spring.mapper.UserMapper;
import com.spring.service.UserLoginService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户登录
 * <p>
 * 失败 Page.PAGE_INDEX
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userLoginServiceImpl")
public class UserLoginServiceImpl implements UserLoginService {

    private Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);


    @Override
    public boolean isUserExisted(String userName) {
        return false;
    }

    @Override
    public UserDO queryUserByName(String userName) {
        return null;
    }
}

