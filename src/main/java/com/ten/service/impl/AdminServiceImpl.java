package com.ten.service.impl;

import com.ten.entity.Admin;
import com.ten.mapper.AdminMapper;
import com.ten.service.AdminService;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ten.util.ServiceCheckUtil.checkObjectDataNotNull;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    private final AdminMapper adminMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 获取所有admin信息
     */
    @Override
    public List<Admin> readAdminList() {
        return adminMapper.selectAdminList();
    }

    /**
     * 获取admin信息
     *
     * @param adminName admin_name
     */
    @Override
    public Admin readAdminByName(String adminName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("adminName", adminName);
        return adminMapper.selectAdminByName(map);
    }

    /**
     * 创建admin信息
     *
     * @param admin DO
     */
    @Override
    public int createAdmin(Admin admin) {
        // check properties
        checkObjectDataNotNull(admin.getAdminName());
        checkObjectDataNotNull(admin.getAdminPassword());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        admin.setAdminGmtCreate(create);
        admin.setAdminGmtModified(modified);
        admin.setAdminLevel("admin");
        return adminMapper.insertAdmin(admin);
    }

    /**
     * 更新admin信息
     *
     * @param admin DO
     */
    @Override
    public int updateAdmin(Admin admin) {
        // check properties
        checkObjectDataNotNull(admin.getAdminId());
        checkObjectDataNotNull(admin.getAdminName());
        checkObjectDataNotNull(admin.getAdminPassword());
        checkObjectDataNotNull(admin.getAdminLevel());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        admin.setAdminGmtModified(modified);
        return adminMapper.updateAdmin(admin);
    }

    /**
     * 删除admin信息
     *
     * @param adminId admin_id
     */
    @Override
    public int deleteAdminById(int adminId) {
        return adminMapper.deleteAdminById(adminId);
    }
}
