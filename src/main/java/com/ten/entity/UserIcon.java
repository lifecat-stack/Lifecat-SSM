package com.ten.entity;

/**
 * DO :user_icon
 *
 * @auther ten
 */
public class UserIcon {

    private Integer userId;
    private String iconPath;
    private String iconGmtCreate;
    private String iconGmtModified;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getIconGmtCreate() {
        return iconGmtCreate;
    }

    public void setIconGmtCreate(String iconGmtCreate) {
        this.iconGmtCreate = iconGmtCreate;
    }

    public String getIconGmtModified() {
        return iconGmtModified;
    }

    public void setIconGmtModified(String iconGmtModified) {
        this.iconGmtModified = iconGmtModified;
    }

    /**
     * @return UserIcon@1234{UserID:'',Path:'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "UserIcon@" + userId
                + "{UserID:" + userId
                + ",Path:" + iconPath
                + ",Create:" + iconGmtCreate
                + ",Modified:" + iconGmtModified
                + "}";
    }
}


