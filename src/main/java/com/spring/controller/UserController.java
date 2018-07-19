package com.spring.controller;

import com.spring.dto.UserDTO;
import com.spring.entity.UserDO;
import com.spring.exception.impl.ServiceNotFoundException;
import com.spring.exception.impl.UserNotFoundException;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        if (this.userService == null){
            throw new ServiceNotFoundException(userService.getClass().getName());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<UserDO> getUserList() {
        List<UserDO> userList = userService.readUserList();
        if (userList == null) {
            throw new UserNotFoundException();
        }
        return userList;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET, produces = "application/json")
    public UserDO getUser(@PathVariable("userName") String userName) {
        UserDO userDO = userService.readUserByName(userName);
        if (userDO == null) {
            throw new UserNotFoundException(userName);
        }
        return userDO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postUser(@RequestBody UserDTO userDTO) {
        // TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String putUser(@RequestBody UserDTO userDTO) {
        // TODO
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") String userId) {
        // TODO
        return null;
    }
}
