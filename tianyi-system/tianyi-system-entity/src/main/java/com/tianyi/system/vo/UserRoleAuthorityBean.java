package com.tianyi.system.vo;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Operation;
import com.tianyi.system.entity.Role;
import com.tianyi.system.entity.User;

import java.util.Set;

/**
 * @author : LiYong
 * @program : UserRoleAuthorityBean
 * @description : 权限报表 包装类
 * @date : 2019/9/10 15:12
 */
public class UserRoleAuthorityBean extends UserBean {

    // 用户角色
    private Set<Role> roles;

    // 用户权限
    private Set<Authority> authorities;

    // 权限范围（权限操作）
    private Set<Operation> operations;


    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
