package com.spring.controller;

import com.spring.dto.Result;
import com.spring.dto.UserDTO;
import com.spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/v1")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 获取所有user信息
     */
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Result<List<UserDTO>> getUserList() {
        logger.debug("user list request");
        return userService.getUserList();
    }

    /**
     * 获取user信息 by userId
     */
    @ResponseBody
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Result getUser(@RequestParam("userId") String userId) {

        int id = Integer.parseInt(userId);
        return userService.deleteUserById(id);
    }

    /**
     * 创建user信息 by userDTO
     */
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Result postUser(@RequestBody UserDTO userDTO) {

        return userService.postUser(userDTO);
    }

    /**
     * 更新user信息 by userDTO
     */
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Result putUser(@RequestBody UserDTO userDTO) {

        return userService.putUser(userDTO);
    }

    /**
     * 删除user信息 by userId
     */
    @ResponseBody
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public Result deleteUser(@RequestParam("userId")String userId) {

        int id = Integer.parseInt(userId);
        return userService.deleteUserById(id);
    }
}
