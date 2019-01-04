package com.ten.lifecat.ssm.service;

import com.ten.lifecat.ssm.entity.Admin;
import com.ten.lifecat.ssm.mapper.AdminDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
