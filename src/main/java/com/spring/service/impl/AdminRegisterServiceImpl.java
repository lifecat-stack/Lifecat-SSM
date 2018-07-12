package com.spring.service.impl;

import com.spring.entity.AdminDO;
import com.spring.service.AdminRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员注册
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("adminRegisterService")
public class AdminRegisterServiceImpl implements AdminRegisterService {
    private Logger logger = LoggerFactory.getLogger(AdminRegisterServiceImpl.class);


    @Override
    public boolean isAdminExisted(String adminName) {
        return false;
    }

    @Override
    public void insertAdminToDatabase(AdminDO adminDO) {

    }
}
