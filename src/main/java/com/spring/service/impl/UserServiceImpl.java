package com.spring.service.impl;

import com.spring.entity.UserDO;
import com.spring.mapper.UserIconMapper;
import com.spring.mapper.UserMapper;
import com.spring.mapper.UserPropertyMapper;
import com.spring.service.UserService;
import com.spring.util.DateTimeUtil;
import com.spring.util.MybatisStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPropertyMapper userPropertyMapper;
    @Autowired
    private UserIconMapper userIconMapper;


    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Override
    public List<UserDO> readUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public UserDO readUserByName(String userName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("userName", userName);
        return userMapper.selectUserByName(map);
    }

    @Override
    public void createUser(UserDO userDO) {
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        userDO.setUserGmtCreate(create);
        userDO.setUserGmtModified(modified);
        userMapper.insertUser(userDO);
    }

    @Override
    public void updateUser(UserDO userDO) {
        String modified = dateTimeUtil.getCurrentTime();
        userDO.setUserGmtModified(modified);
        userMapper.updateUser(userDO);
    }

    @Override
    public void deleteUserById(int userId) {
        userMapper.deleteUserById(userId);
    }
}