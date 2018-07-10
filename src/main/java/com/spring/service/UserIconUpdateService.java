package com.spring.service;


import com.spring.entity.UserIconDO;

/**
 * 用户头像上传
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserIconUpdateService{
    void updateUserIcon(UserIconDO userIconDO);
}
