package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.User;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
import com.ten.util.ControllerUtil;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Controller
 *
 * @author wshten
 * @date 2018/11/10
 */
@RestController
@RequestMapping("/user/v1")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "SUCCESS";

    private ControllerUtil checkUtil = ControllerUtil.getInstance();
    private DateTimeUtil timeUtil = DateTimeUtil.getInstance();

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get All User Data
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultModel getUserList() {
        User user = new User()
                .setIsDeleted(0);

        List<User> users = userService.select(user);
        if (users.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户查询为空");
        }
        return new ResultModel(ResponseCode.OK, users);
    }

    /**
     * Get User By UserName
     */
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public ResultModel getUser(@PathVariable("userName") @NotNull String userName) {
        User user = new User()
                .setUserName(userName)
                .setIsDeleted(0);

        List<User> users = userService.select(user);
        if (users.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "未查询到指定用户{userName:" + userName + "}");
        }
        return new ResultModel(ResponseCode.OK, users.get(0));
    }

    /**
     * Create New User
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postUser(@RequestParam @NotNull String userName,
                                @RequestParam @NotNull String userPassword) {
        String current = timeUtil.getCurrentTime();

        User user = new User()
                .setUserName(userName)
                .setUserPassword(userPassword)
                .setUserLevel("user")
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(0);

        Integer result = userService.insert(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "创建用户失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update User
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putUser(@RequestParam @NotNull String userName,
                               @RequestParam @NotNull String userPassword) {
        String current = timeUtil.getCurrentTime();

        User user = new User()
                .setUserName(userName)
                .setUserPassword(userPassword)
                .setUpdateTime(current);

        Integer result = userService.update(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "更新用户失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Delete User By UserId
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResultModel deleteUser(@PathVariable("userId") @NotNull String userId) {
        checkUtil.isFormatInt(userId);

        String current = timeUtil.getCurrentTime();

        User user = new User()
                .setId(Integer.valueOf(userId))
                .setUpdateTime(current)
                .setIsDeleted(1);

        Integer result = userService.update(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "删除用户失败:" + userId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }
}
