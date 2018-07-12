package com.spring.service.impl;

import com.spring.entity.AdminDO;
import com.spring.service.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 管理员登录
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(AdminLoginServiceImpl.class);

    @Override
    public boolean isAdminExisted(String adminName) {
        return false;
    }

    @Override
    public AdminDO queryAdminByName(String adminName) {
        return null;
    }
}
