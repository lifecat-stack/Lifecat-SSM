package com.ten.service;

import com.ten.entity.UserIcon;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ten.mapper.UserIconDao;

@Service
public class UserIconService {

    @Resource
    private UserIconDao userIconDao;

    public int insert(UserIcon pojo){
        return userIconDao.insert(pojo);
    }

    public int insertList(List< UserIcon> pojos){
        return userIconDao.insertList(pojos);
    }

    public List<UserIcon> select(UserIcon pojo){
        return userIconDao.select(pojo);
    }

    public int update(UserIcon pojo){
        return userIconDao.update(pojo);
    }

}
