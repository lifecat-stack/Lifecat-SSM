package com.spring.mapper;


import com.spring.entity.UserDO;
import java.util.List;
import java.sql.SQLException;

/**
 * dao - user
 * <p>
 * 1. 查询user queryUserByName()
 * 2. 插入user insertUser()
 * 3. 查询密码 queryUserPassword()
 * 4. 更新密码 updateUserPassword()
 * 5. 查询user是否存在 isUserExisted()
 *
 * @auther ten
 */
public interface UserMapper {
    List<UserDO> queryUserList();

    /**
     * 注册 :
     * 插入UserDO到user表
     * 返回自增主键user_id
     *
     * @param userDO UserDO
     *               e
     */
    int insertUserAndGetKey(UserDO userDO);

    /**
     * 登录 :
     * 通过user_name(uk)进行查询
     * 获取数据库user信息
     * user信息封装在UserDO中返回
     *
     * @param userName 用户名
     * @return UserDO UserDO

     * @throws NullPointerException 记录不存在
     */
    UserDO queryUserByName(String userName);

    /**
     * 注册-用户是否存在 :
     * 通过user_name(uk)进行查询
     * 判断user是否存在
     *
     * @param userName 用户名
     * @return boolean 用户名是否存在
     */
    boolean isUserExistedByName(String userName);

    /**
     * 密码更新 :
     * 通过useName获取密码
     *
     * @param userName 用户名
     * @return user_password
     */
    String queryUserPasswordByName(String userName);

    /**
     * 密码更新 :
     * 更新用户密码
     * <p>
     */
    void updateUserPassword(UserDO userDO);
}
