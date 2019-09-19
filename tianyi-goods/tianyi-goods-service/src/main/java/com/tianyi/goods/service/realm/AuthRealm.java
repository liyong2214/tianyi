package com.tianyi.goods.service.realm;

import com.tianyi.goods.entity.Authority;
import com.tianyi.goods.entity.Role;
import com.tianyi.goods.entity.User;
import com.tianyi.goods.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: tianyi
 * @description: 认证授权
 * @author: Simon
 * @create: 2019-09-10 15:13
 **/

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleAuthorityService roleAuthorityService;


    @Autowired
    private IAuthorityService authorityService;


    @Override
    public String getName() {
        return "authRealm";
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm("authRealm").iterator().next();
        Set<Integer> roleIds = userRoleService.findRolesByUserId(user.getUserId());
        List<String> roleNameList = new ArrayList<>();
        List<String> authorityNameList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(roleIds)) {
            for (Integer rid : roleIds) {
                Role role = roleService.findById(rid);
                roleNameList.add(role.getRoleName());
                Set<Integer> authorithIds = roleAuthorityService.findAuthorithByRoleId(rid);
                if (CollectionUtils.isNotEmpty(authorithIds)) {
                    for (Integer aid : authorithIds) {
                        Authority authority = authorityService.findById(aid);
                        authorityNameList.add(authority.getAuthorityName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(authorityNameList);
        info.addRoles(roleNameList);

        return info;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String account = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
//        String account = (String) authenticationToken.getPrincipal();
        User user = userService.selectUserByAccount(account, password);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getUserPassword(), "authRealm");

        return simpleAuthenticationInfo;
    }
}
