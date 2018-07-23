package com.spring.service.impl;

import com.spring.entity.AdminDO;
import com.spring.mapper.AdminMapper;
import com.spring.service.AdminService;
import com.spring.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.spring.util.ServiceCheckUtil.checkObjectDataNotNull;

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
    public List<AdminDO> readAdminList() {
        return adminMapper.selectAdminList();
    }

    /**
     * 获取admin信息
     *
     * @param adminName admin_name
     */
    @Override
    public AdminDO readAdminByName(String adminName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("adminName", adminName);
        return adminMapper.selectAdminByName(map);
    }

    /**
     * 创建admin信息
     *
     * @param adminDO DO
     */
    @Override
    public int createAdmin(AdminDO adminDO) {
        // check properties
        checkObjectDataNotNull(adminDO.getAdminName());
        checkObjectDataNotNull(adminDO.getAdminPassword());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        adminDO.setAdminGmtCreate(create);
        adminDO.setAdminGmtModified(modified);
        adminDO.setAdminLevel("admin");
        return adminMapper.insertAdmin(adminDO);
    }

    /**
     * 更新admin信息
     *
     * @param adminDO DO
     */
    @Override
    public int updateAdmin(AdminDO adminDO) {
        // check properties
        checkObjectDataNotNull(adminDO.getAdminId());
        checkObjectDataNotNull(adminDO.getAdminName());
        checkObjectDataNotNull(adminDO.getAdminPassword());
        checkObjectDataNotNull(adminDO.getAdminLevel());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        adminDO.setAdminGmtModified(modified);
        return adminMapper.updateAdmin(adminDO);
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
