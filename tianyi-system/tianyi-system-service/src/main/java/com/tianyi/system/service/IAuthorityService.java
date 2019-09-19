package com.tianyi.system.service;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Role;
import com.tianyi.system.vo.AuthorityBean;

import java.util.List;

/**
 * @author : LiYong
 * @program : IAuthorityService
 * @description : 权限接口
 * @date : 2019/9/10 11:00
 */
public interface IAuthorityService {

    /**
     * 查询所有权限
     *
     * @return 权限列表
     */
    List<AuthorityBean> listAuthority();

    /**
     * 根据角色查询权限列表
     * @param role
     * @return
     */
    List<Authority> listAuthorityByRole(Role role);

    /**
     * 添加权限
     *
     * @param authorityBean 新增信息
     */
    void saveAuthority(AuthorityBean authorityBean);

    /**
     * 修改权限
     * @param authorityBean 修改信息
     */
    void updateAuthority(AuthorityBean authorityBean);

    /**
     * 删除权限
     * @param authorityId 权限id
     */
    void deleteAuthority(Integer authorityId);
}
