package com.spring.service;

import com.spring.dto.Result;
import com.spring.dto.UserDTO;

import java.util.List;

/**
 * User
 *
 * @date 2018/7/17
 * @auther ten
 */
public interface UserService {
    /**
     * 获取所有user信息
     */
    public Result<List<UserDTO>> getUserList();

    /**
     * 获取user信息
     *
     * @param userId 用户ID
     */
    public Result<UserDTO> getUserById(int userId);

    /**
     * 创建user信息
     *
     * @param userDTO 用户DTO
     */
    public Result postUser(UserDTO userDTO);

    /**
     * 更新user信息
     *
     * @param userDTO 用户DTO
     */
    public Result putUser(UserDTO userDTO);

    /**
     * 删除user信息
     *
     * @param userId 用户ID
     */
    public Result deleteUserById(int userId);
}