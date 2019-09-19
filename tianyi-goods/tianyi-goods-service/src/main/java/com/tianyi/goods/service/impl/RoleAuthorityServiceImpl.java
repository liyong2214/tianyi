package com.tianyi.goods.service.impl;

import com.tianyi.goods.entity.Role;
import com.tianyi.goods.entity.RoleAuthorityExample;
import com.tianyi.goods.entity.RoleAuthorityKey;
import com.tianyi.goods.mapper.RoleAuthorityMapper;
import com.tianyi.goods.service.IRoleAuthorityService;
import com.tianyi.goods.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: tianyi
 * @description: IRoleAuthorityService实现类
 * @author: Simon
 * @create: 2019-09-10 23:39
 **/
@Service
@Transactional
public class RoleAuthorityServiceImpl implements IRoleAuthorityService {


    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private IRoleService roleService;

    /**
     * @param id 依据角色id查询对应的权限id
     * @return
     */
    @Override
    public Set<Integer> findAuthorithByRoleId(Integer id) {
        Set<Integer> authoritySet = new HashSet<>();
        if (id == null) {
            return null;
        }

        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        RoleAuthorityExample.Criteria criteria = roleAuthorityExample.createCriteria();
        criteria.andRoleIdEqualTo(id);
        List<RoleAuthorityKey> authorityKeys = roleAuthorityMapper.selectByExample(roleAuthorityExample);

        for (RoleAuthorityKey roleAuthorityKey : authorityKeys) {
            authoritySet.add(roleAuthorityKey.getAuthorityId());
        }
        return authoritySet;
    }


    /**
     * <H2>依据传入的权限id，查询拥有该权限的所有role</H2>
     *
     * @param id {权限id}
     * @return {角色集合}
     */
    @Override
    public Set<Role> findRoleByAuthority(Integer id) {
        Set<Role> roleSet = new HashSet<>();
        if (id == null) {
            return null;
        }

        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        RoleAuthorityExample.Criteria criteria = roleAuthorityExample.createCriteria();
        criteria.andAuthorityIdEqualTo(id);

        List<RoleAuthorityKey> roleAuthorityKeys = roleAuthorityMapper.selectByExample(roleAuthorityExample);
        for (RoleAuthorityKey ra : roleAuthorityKeys) {

            Role role = roleService.findById(ra.getRoleId());
            roleSet.add(role);

        }


        return roleSet;
    }
}
