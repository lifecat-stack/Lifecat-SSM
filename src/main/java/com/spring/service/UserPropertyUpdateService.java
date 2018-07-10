package com.spring.service;


import com.spring.entity.UserDO;

/**
 * 用户资料更新
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPropertyUpdateService{
    void updateUserProperty(UserDO userDO);
}