package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.User;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ten.util.ControllerCheckUtil.*;

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
        logger.info("访问方法:"+Thread.currentThread().getStackTrace()[1].getMethodName());
        List<User> userList = userService.readUserList();
        if (userList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户集合查询失败");
        }
        return new ResultModel(ResponseCode.OK, userList);
    }

    /**
     * Get User By UserName
     */
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public ResultModel getUser(@PathVariable("userName") @NotNull String userName) {
        logger.info("访问方法:"+Thread.currentThread().getStackTrace()[1].getMethodName());
        User user = userService.readUserByName(userName);
        if (user == null) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "未查询到指定用户{userName:" + userName + "}");
        }
        return new ResultModel(ResponseCode.OK, user);
    }

    /**
     * Create New User
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postUser(@RequestBody @NotNull User user) {
        Integer result = userService.createUser(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "创建用户失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update User
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putUser(@RequestBody @NotNull User user) {
        Integer result = userService.updateUser(user);
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
        checkRquestDataFormatInt(userId);

        Integer result = userService.deleteUserById(Integer.parseInt(userId));
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "删除用户失败:" + userId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }
}
