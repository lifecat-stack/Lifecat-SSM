package com.ten.service.impl;

import com.ten.entity.User;
import com.ten.mapper.UserIconMapper;
import com.ten.mapper.UserMapper;
import com.ten.mapper.UserPropertyMapper;
import com.ten.service.UserService;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ten.util.ServiceCheckUtil.*;


@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;
    private final UserPropertyMapper userPropertyMapper;
    private final UserIconMapper userIconMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserPropertyMapper userPropertyMapper, UserIconMapper userIconMapper) {
        this.userMapper = userMapper;
        this.userPropertyMapper = userPropertyMapper;
        this.userIconMapper = userIconMapper;
    }

    /**
     * 获取所有user信息
     */
    @Override
    public List<User> readUserList() {
        return userMapper.selectUserList();
    }

    /**
     * 获取user信息
     *
     * @param userName user_name
     */
    @Override
    public User readUserByName(String userName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("userName", userName);
        return userMapper.selectUserByName(map);
    }

    /**
     * 创建user信息
     *
     * @param user DO
     */
    @Override
    public int createUser(User user) {
        // check properties
        checkObjectDataNotNull(user.getUserName());
        checkObjectDataNotNull(user.getUserPassword());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        user.setCreateTime(create);
        user.setUpdateTime(modified);
        user.setUserLevel("user");
        return userMapper.insertUser(user);
    }

    /**
     * 更新user信息
     *
     * @param user DO
     */
    @Override
    public int updateUser(User user) {
        // check properties
        checkObjectDataNotNull(user.getUserId());
        checkObjectDataNotNull(user.getUserName());
        checkObjectDataNotNull(user.getUserPassword());
        checkObjectDataNotNull(user.getUserLevel());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        user.setUpdateTime(modified);
        return userMapper.updateUser(user);
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