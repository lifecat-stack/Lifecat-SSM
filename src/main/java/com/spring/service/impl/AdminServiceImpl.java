package com.spring.service.impl;

import com.spring.mapper.AdminMapper;
import com.spring.service.AdminService;
import com.spring.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    private final AdminMapper adminMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
}
