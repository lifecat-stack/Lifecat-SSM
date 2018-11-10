package com.ten.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.ten.entity.Admin;
import com.ten.mapper.AdminDao;

@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public int insert(Admin pojo) {
        return adminDao.insert(pojo);
    }

    public int insertList(List<Admin> pojos) {
        return adminDao.insertList(pojos);
    }

    public List<Admin> select(Admin pojo) {
        return adminDao.select(pojo);
    }

    public int update(Admin pojo) {
        return adminDao.update(pojo);
    }

    public int delete(Admin pojo) {
        return adminDao.delete(pojo);
    }

}
