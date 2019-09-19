package com.tianyi.system.service;

import com.tianyi.system.entity.Role;
import com.tianyi.system.vo.RoleBean;

import java.util.List;

/**
 * @author : LiYong
 * @program : IRoleService
 * @description : 角色service接口
 * @date : 2019/9/8 17:09
 */
public interface IRoleService {

    /**
     * 查询所有的角色
     * @return 角色列表
     */
    List<RoleBean> listRole();

    /**
     * 通过用户账号查询角色列表
     * @param userAccount 用户账号
     * @return 角色列表
     */
    List<Role> listRoleByUserAccount(String userAccount);

    /**
     * 添加角色
     */
    void saveRole(RoleBean roleBean);

    /**
     * 修改角色
     * @param roleBean 角色信息
     */
    void updateRole(RoleBean roleBean);

    /**
     * 删除角色
     * @param roleId 角色id
     */
    void removeRole(Integer roleId);
}
