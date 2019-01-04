package com.ten.lifecat.ssm.dto;

/**
 * 系统中公用常量
 */
public interface PublicConstant {

    /*--------------------------- mybatis分页插件相关 ---------------------------*/
    String PAGE_DEFAULT = "10";//每页默认数据条数

    /*--------------------------- 登录相关 ---------------------------*/
    String USER_INFO_SESSION_KEY = "theLoginUser";//当前登录用户信息存于session中的key
    String USER_ROLE_TYPE = "theLoginUserRoleType";//当前登录用户所属角色存于session中的key

    /*--------------------------- 正则相关 ---------------------------*/
    String PHONE_REG = "^1[3-9][0-9]\\d{4,8}$";//手机号正则
    String TELPHONE_REG = "^[0][0-9]{2,3}-[0-9]{5,10}$";//座机号正则
    String EMAIL_REG = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";//邮箱正则

    /*--------------------------- 文件服务器相关 ---------------------------*/
    String FILE_FDFS_PREFIX = "http://file.ahtusi.com:8888/";//文件上传至文件服务器后，文件访问前缀
    String USER_DEFAULT_FACE_IMG = FILE_FDFS_PREFIX + "group1/M00/07/05/rBEADlwh9vuAe9BuAANG0ITkBf4495.jpg";//用户默认头像

    /*--------------------------- 菜单相关 ---------------------------*/
    long TOP_MENU_ID = 1L;//顶级菜单的ID
    long TOP_MENU_PARENT_ID = 0;//顶级菜单的父级菜单ID ==> 特殊值'0'
    long FIRST_MENU_PARENT_ID = 1L;//一级菜单的父级菜单ID ==> 顶级菜单的ID

    /*--------------------------- 接口相关 ---------------------------*/
    int OK = 0;//成功
    int ERROR = 1;//失败
    int UNLOGIN = -1;//未登录，或登录失效
    Object NULL = null;//空信息

}
