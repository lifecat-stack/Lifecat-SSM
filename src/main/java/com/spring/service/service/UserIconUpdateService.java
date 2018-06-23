package com.spring.service.service;


import com.spring.entity.UserIconDO;
import com.spring.service.Service;

/**
 * 用户头像上传
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserIconUpdateService extends Service {
    void updateUserIcon(UserIconDO userIconDO);
}
