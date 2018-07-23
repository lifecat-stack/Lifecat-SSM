package com.spring.mapper;

import com.spring.entity.AdminDO;
import com.spring.entity.AdminDO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface AdminMapper {
    List<AdminDO> selectAdminList();

    AdminDO selectAdminByName(Map<String,String> adminMap);

    int insertAdmin(AdminDO adminDO);

    int updateAdmin(AdminDO adminDO);

    int deleteAdminById(int adminId);
}