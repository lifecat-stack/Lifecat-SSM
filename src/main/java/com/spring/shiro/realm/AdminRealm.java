package com.spring.shiro.realm;

import com.spring.entity.AdminDO;
import com.spring.entity.UserDO;
import com.spring.mapper.AdminMapper;
import com.spring.mapper.UserMapper;
import com.spring.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * shiro admin 拦截器
 *
 * @author Administrator
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    /**
     * 授权
     * <p>
     * subject.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 数据需要从数据库中查询

        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        // 根据角色ID查询角色（role），放入到Authorization里。
        Set<String> roles = new HashSet<String>();
        roles.add("角色1");
        roles.add("角色2");
        simpleAuthorInfo.setRoles(roles);
        // 根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = new HashSet<String>();
        permissions.add("权限1");
        permissions.add("权限2");
        simpleAuthorInfo.setStringPermissions(permissions);
        return simpleAuthorInfo;
    }

    /**
     * 认证
     * <p>
     * subject.login()
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.把AuthenticationToken转换成UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 2.从UsernamePasswordToken获取username
        String adminName = token.getUsername();
        AdminDO admin = adminService.readAdminByName(adminName);
        // 3.验证
        if (admin != null) {
            return new SimpleAuthenticationInfo(
                    admin.getAdminName(), admin.getAdminPassword(), getName());
        } else {
            throw new UnknownAccountException();
        }
    }
}
