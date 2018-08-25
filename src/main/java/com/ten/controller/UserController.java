package com.ten.controller;

import com.ten.entity.UserDO;
import com.ten.dto.ResponseResult;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ten.util.ControllerCheckUtil.*;

/**
 * user rest
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/user/v1")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        checkResourceNotNull(userService, "userService not load");
    }

    /**
     * 查询user list
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<UserDO> getUserList() {
        // execute
        List<UserDO> userList = userService.readUserList();
        // return
        checkResourceNotNull(userList, "user list is null");
        return userList;
    }

    /**
     * 查询user
     *
     * @param userName user_name
     */
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET, produces = "application/json")
    public UserDO getUser(@PathVariable("userName") @NotNull String userName) {
        // check
        checkRequestDataNotNull(userName);
        // execute
        UserDO userDO = userService.readUserByName(userName);
        // return
        checkResourceNotNull(userDO, userName + " is not found");
        return userDO;
    }

    /**
     * 创建user
     *
     * @param userDO user
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseResult postUser(@RequestBody @NotNull UserDO userDO) {
        // check
        checkRequestDataNotNull(userDO);
        // execute
        int result = userService.createUser(userDO);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult("user create success");
    }

    /**
     * 更新user
     *
     * @param userDO user
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseResult putUser(@RequestBody @NotNull UserDO userDO) {
        // check
        checkRequestDataNotNull(userDO);
        // execute
        int result = userService.updateUser(userDO);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult("user update success");
    }

    /**
     * 删除user
     *
     * @param userId user_id
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseResult deleteUser(@PathVariable("userId") @NotNull String userId) {
        // check
        checkRequestDataNotNull(userId);
        checkRquestDataFormatInt(userId);
        // execute
        int id = Integer.parseInt(userId);
        int result = userService.deleteUserById(id);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult("user delete success");
    }
}
