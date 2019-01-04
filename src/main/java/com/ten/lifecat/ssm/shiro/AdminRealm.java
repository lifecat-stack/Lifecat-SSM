package com.ten.lifecat.ssm.shiro;

import com.ten.lifecat.ssm.entity.Admin;
import com.ten.lifecat.ssm.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
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
     * 认证 :subject.login()
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 把AuthenticationToken转换成UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 从UsernamePasswordToken获取username
        String adminName = token.getUsername();
        Admin entity = new Admin().setAdminName(adminName).setIsDeleted(0);
        Admin admin = adminService.select(entity).get(0);

        // SUCCESS
        if (admin != null) {
            return new SimpleAuthenticationInfo(admin.getAdminName(), admin.getAdminPassword(), getName());
        }
        // ERROR
        else {
            throw new UnknownAccountException();
        }
    }
}
