package com.spring.service.impl;

import com.spring.dto.Code;
import com.spring.dto.Result;
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


/**
 * User
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPropertyMapper userPropertyMapper;
    @Autowired
    private UserIconMapper userIconMapper;

    /**
     * 获取所有user信息
     */
    @Override
    public Result<List<UserDTO>> getUserList() {
        // user table
        List<UserDO> users = userMapper.queryUserList();

        logger.debug("user list size:" + users.size());

        // user 模块数据
        List<UserDTO> userList = new ArrayList<UserDTO>(16);

        // create userDTO
        // TODO 将循环单次SQL查询 -> 通过关联一次性匹配查询
        for (int i = 0; i < 1; i++) {
            UserDO user = users.get(i);
            int userId = user.getUserId();

            logger.info(String.valueOf(userId));

            UserPropertyDO userPropertyDO = userPropertyMapper.queryUserPropertyById(userId);
            UserIconDO userIconDO = userIconMapper.queryUserIconByUserId(userId);

            logger.debug(userPropertyDO.getPropertyNickname());
            logger.debug(userIconDO.getIconPath());

            UserDTO userDTO = new UserDTO();
            userDTO.setUserDO(user);
            userDTO.setUserPropertyDO(userPropertyDO);
            userDTO.setUserIconDO(userIconDO);

            userList.add(userDTO);
        }

        logger.debug("nickname is " + userList.get(0).getUserPropertyDO().getPropertyNickname());

        Result<List<UserDTO>> result = new Result<List<UserDTO>>();
        result.setSuccess(true);
        result.setCode(Code.SUCCESS_200);
        result.setJsonData(userList);

        return result;
    }

    /**
     * 获取user信息
     *
     * @param userId 用户ID
     */
    @Override
    public Result<UserDTO> getUserById(int userId) {
        return null;
    }

    /**
     * 创建user信息
     *
     * @param userDTO 用户DTO
     */
    @Override
    public Result postUser(UserDTO userDTO) {
        return null;
    }

    /**
     * 更新user信息
     *
     * @param userDTO 用户DTO
     */
    @Override
    public Result putUser(UserDTO userDTO) {
        return null;
    }

    /**
     * 删除user信息
     *
     * @param userId 用户ID
     */
    @Override
    public Result deleteUserById(int userId) {
        return null;
    }
}