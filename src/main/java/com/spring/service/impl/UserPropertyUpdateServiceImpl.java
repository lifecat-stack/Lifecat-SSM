package com.spring.service.impl;

import com.spring.entity.UserDO;
import com.spring.service.UserPropertyUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户资料更新
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userPropertyUpdateService")
public class UserPropertyUpdateServiceImpl implements UserPropertyUpdateService {

    private Logger logger = LoggerFactory.getLogger(UserPropertyUpdateServiceImpl.class);

    @Override
    public void updateUserProperty(UserDO userDO) {

    }
}