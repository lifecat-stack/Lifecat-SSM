package com.spring.service.impl;

import com.spring.entity.UserPropertyDO;
import com.spring.service.UserPropertyQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 查询用户资料
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userPropertyQueryService")
public class UserPropertyQueryServiceImpl implements UserPropertyQueryService {

    private Logger logger = LoggerFactory.getLogger(UserPropertyQueryServiceImpl.class);


    @Override
    public UserPropertyDO queryUserProperty(int userId) {
        return null;
    }
}