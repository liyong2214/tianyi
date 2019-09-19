package com.tianyi.goods.service;

import com.tianyi.goods.entity.Role;

import java.util.Set;

/**
 * @program: tianyi
 * @description: 角色权限service
 * @author: Simon
 * @create: 2019-09-10 23:38
 **/
public interface IRoleAuthorityService {


    /**
     * @param id 依据角色id查询对应的权限id
     * @return
     */
    Set<Integer> findAuthorithByRoleId(Integer id);


    /**
     * <H2>依据传入的权限id，查询拥有该权限的所有role</H2>
     *
     * @param id
     * @return
     */
    Set<Role> findRoleByAuthority(Integer id);
}
