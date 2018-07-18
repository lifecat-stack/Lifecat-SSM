package com.spring.mapper;


import com.spring.entity.UserDO;

import java.util.List;
import java.sql.SQLException;


public interface UserMapper {
    List<UserDO> selectUserList();

    UserDO selectUserByName(String userName);

    void insertUser(UserDO userDO);

    void updateUser(UserDO userDO);

    void deleteUserById(int userId);
}
