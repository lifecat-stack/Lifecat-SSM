package com.spring.mapper;


import com.spring.entity.UserDO;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    List<UserDO> selectUserList();

    UserDO selectUserByName(Map<String,String> userMap);

    int insertUser(UserDO userDO);

    int updateUser(UserDO userDO);

    int deleteUserById(int userId);
}
