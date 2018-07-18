package com.spring.service.impl;

import com.spring.dto.UserDTO;
import com.spring.entity.UserDO;
import com.spring.entity.UserIconDO;
import com.spring.entity.UserPropertyDO;
import com.spring.mapper.UserIconMapper;
import com.spring.mapper.UserMapper;
import com.spring.mapper.UserPropertyMapper;
import com.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPropertyMapper userPropertyMapper;
    @Autowired
    private UserIconMapper userIconMapper;


    @Override
    public List<UserDO> readUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public UserDO readUserById(int userId) {
        return null;
    }

    @Override
    public void createUser(UserDO userDO) {

    }

    @Override
    public void updateUser(UserDO userDO) {

    }

    @Override
    public void deleteUserById(int userId) {

    }
}