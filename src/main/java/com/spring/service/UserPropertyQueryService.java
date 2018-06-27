package com.spring.service;


import com.spring.entity.UserPropertyDO;
import com.spring.service.util.Service;

/**
 * 查询用户资料
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPropertyQueryService extends Service {
    UserPropertyDO queryUserProperty(int userId);
}