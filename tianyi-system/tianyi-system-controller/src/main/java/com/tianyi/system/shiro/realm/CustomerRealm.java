package com.tianyi.system.shiro.realm;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Role;
import com.tianyi.system.entity.User;
import com.tianyi.system.service.IAuthorityService;
import com.tianyi.system.service.IRoleService;
import com.tianyi.system.service.IUserService;
import com.tianyi.system.util.OJsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : LiYong
 * @program : CustomerRealm
 * @description : 自定义realm
 * @date : 2019/9/11 16:47
 */
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAuthorityService authorityService;


    // 模拟数据库数据
//    private Map<String, String> userMap = new HashMap<>(16);

    {
//        userMap.put("Mark", "e10adc3949ba59abbe56e057f20f883e");  // password = 123456
        super.setName("customerRealm");  // 设置自定义ream的名称
    }

    /**
     * 授权，当用户访问需要权限的url时，会调用此方法查询权限
     * 方法的调用时机为需授权资源被访问时
     * 若每次访问需授权资源时都会执行方法中的逻辑，这表明并未启用AuthorizationCache
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库获取角色和权限数据
        Set<String> roles = getRolesByUsrName(userName);
        Set<String> permissions = getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }


    // 从数据库获取权限数据
    private Set<String> getPermissionsByUserName(String userName) {
        List<Role> roleList = roleService.listRoleByUserAccount(userName);
        Set<String> permissions = new HashSet<>();
        for (Role role : roleList) {
            List<Authority> authorityList = authorityService.listAuthorityByRole(role);
            for (Authority authority : authorityList) {
                permissions.add(authority.getAuthorityName());
            }
        }
        /*permissions.add("user:delete");
        permissions.add("user:add");*/
        return permissions;
    }

    // 从数据库获取角色名称
    private Set<String> getRolesByUsrName(String userName) {
        List<Role> roleList = roleService.listRoleByUserAccount(userName);
        // 放入set集合，不会出现重复数据
        Set<String> roles = new HashSet<>();
        for (Role role : roleList) {
            roles.add(role.getRoleName());
        }
        return roles;
    }


    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 从主体传来的认证信息中，获得用户名
        String userName = (String) authenticationToken.getPrincipal();
        // 通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if (password == null) {
            return null;
        }
        // realm 名称
        String realmName = this.getName();
        return new SimpleAuthenticationInfo(userName, password, realmName);
    }

    // 从数据库中获取角色密码
    private String getPasswordByUserName(String userName) {
        User user = userService.getUser(userName);
        String userStr = OJsonUtil.toString(user);
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("currentUser", userStr);
        return user.getUserPassword();
    }
}
