package com.ten.lifecat.ssm.controller.data;

import com.ten.lifecat.ssm.dto.ResponseCode;
import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.entity.User;
import com.ten.lifecat.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String LEVEL = "user";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResultModel list(User user) {
        user.setIsDeleted(0);

        List<User> users = userService.select(user);
        if (users.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户集合查询失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, users);
    }

    @Override
    public ResultModel get(@RequestBody User user) {
        user.setIsDeleted(0);

        List<User> users = userService.select(user);
        if (users.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户查询失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, users.get(0));
    }

    @Override
    public ResultModel post(@RequestBody User user) {
        String current = super.dateTimeUtil.getCurrentTime();

        user.setUserLevel(LEVEL)
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(0);

        Integer result = userService.insert(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户创建失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel update(@RequestBody User user) {
        String current = super.dateTimeUtil.getCurrentTime();

        user.setUpdateTime(current);

        Integer result = userService.update(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户更新失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel delete(@RequestBody User user) {
        String current = super.dateTimeUtil.getCurrentTime();

        user.setUpdateTime(current)
                .setIsDeleted(IS_DELETED);

        Integer result = userService.update(user);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "用户删除失败:" + user);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }
}
