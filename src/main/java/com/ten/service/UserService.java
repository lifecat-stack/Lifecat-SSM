package com.ten.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ten.entity.User;
import com.ten.mapper.UserDao;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public int insert(User pojo){
        return userDao.insert(pojo);
    }

    public int insertList(List< User> pojos){
        return userDao.insertList(pojos);
    }

    public List<User> select(User pojo){
        return userDao.select(pojo);
    }

    public int update(User pojo){
        return userDao.update(pojo);
    }

}
