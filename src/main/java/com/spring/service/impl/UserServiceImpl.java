package com.spring.service.impl;

import com.spring.entity.UserDO;
import com.spring.mapper.UserIconMapper;
import com.spring.mapper.UserMapper;
import com.spring.mapper.UserPropertyMapper;
import com.spring.service.UserService;
import com.spring.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.spring.util.ServiceCheckUtil.*;


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

    /**
     * 获取所有user信息
     */
    @Override
    public List<UserDO> readUserList() {
        return userMapper.selectUserList();
    }

    /**
     * 获取user信息
     *
     * @param userName user_name
     */
    @Override
    public UserDO readUserByName(String userName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("userName", userName);
        return userMapper.selectUserByName(map);
    }

    /**
     * 创建user信息
     *
     * @param userDO DO
     */
    @Override
    public int createUser(UserDO userDO) {
        // check properties
        checkObjectDataNotNull(userDO.getUserName());
        checkObjectDataNotNull(userDO.getUserPassword());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        userDO.setUserGmtCreate(create);
        userDO.setUserGmtModified(modified);
        userDO.setUserLevel("user");
        return userMapper.insertUser(userDO);
    }

    /**
     * 更新user信息
     *
     * @param userDO DO
     */
    @Override
    public int updateUser(UserDO userDO) {
        // check properties
        checkObjectDataNotNull(userDO.getUserId());
        checkObjectDataNotNull(userDO.getUserName());
        checkObjectDataNotNull(userDO.getUserPassword());
        checkObjectDataNotNull(userDO.getUserLevel());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        userDO.setUserGmtModified(modified);
        return userMapper.updateUser(userDO);
    }

    /**
     * 删除user信息
     *
     * @param userId user_id
     */
    @Override
    public int deleteUserById(int userId) {
        return userMapper.deleteUserById(userId);
    }
}