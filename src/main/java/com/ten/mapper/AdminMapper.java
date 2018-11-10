package com.ten.mapper;

import com.ten.entity.Admin;

import java.util.List;
import java.util.Map;


public interface AdminMapper {
    List<Admin> selectAdminList();

    Admin selectAdminByName(Map<String,String> adminMap);

    int insertAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdminById(int adminId);
}