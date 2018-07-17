package com.spring.dto;

import com.spring.entity.UserDO;
import com.spring.entity.UserIconDO;
import com.spring.entity.UserPropertyDO;

public class UserDTO {
    private UserDO userDO;
    private UserPropertyDO userPropertyDO;
    private UserIconDO userIconDO;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public UserPropertyDO getUserPropertyDO() {
        return userPropertyDO;
    }

    public void setUserPropertyDO(UserPropertyDO userPropertyDO) {
        this.userPropertyDO = userPropertyDO;
    }

    public UserIconDO getUserIconDO() {
        return userIconDO;
    }

    public void setUserIconDO(UserIconDO userIconDO) {
        this.userIconDO = userIconDO;
    }
}
