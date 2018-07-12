package com.spring.service.impl;

import com.spring.entity.UserIconDO;
import com.spring.service.UserIconUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户头像上传
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userIconUpdateService")
public class UserIconUpdateServiceImpl implements UserIconUpdateService {
    private Logger logger = LoggerFactory.getLogger(UserIconUpdateServiceImpl.class);


    @Override
    public void updateUserIcon(UserIconDO userIconDO) {

    }
}
