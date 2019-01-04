package com.ten.lifecat.ssm.service;

import com.ten.lifecat.ssm.entity.UserIcon;
import com.ten.lifecat.ssm.mapper.UserIconDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserIconService {

    @Resource
    private UserIconDao userIconDao;

    public int insert(UserIcon pojo) {
        return userIconDao.insert(pojo);
    }

    public int insertList(List<UserIcon> pojos) {
        return userIconDao.insertList(pojos);
    }

    public List<UserIcon> select(UserIcon pojo) {
        return userIconDao.select(pojo);
    }

    public int update(UserIcon pojo) {
        return userIconDao.update(pojo);
    }

    public int delete(UserIcon pojo) {
        return userIconDao.delete(pojo);
    }

}
