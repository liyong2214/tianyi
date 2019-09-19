package com.tianyi.system.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.tianyi.system.entity.*;
import com.tianyi.system.mapper.*;
import com.tianyi.system.service.IRoleService;
import com.tianyi.system.service.IUserService;
import com.tianyi.system.vo.RoleBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : LiYong
 * @program : RoleServiceImpl
 * @description : 角色service实现类
 * @date : 2019/9/8 17:11
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RoleDepartmentMapper roleDepartmentMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private IUserService userService;

    /**
     * 查询所有的角色
     *
     * @return 角色列表
     */
    @Override
    public List<RoleBean> listRole() {

        List<Role> roleList = roleMapper.selectByExample(null);

        // 要返回的数据
        List<RoleBean> roleBeanList = new ArrayList<>();

        for (Role role : roleList) {
            List<Authority> authorityList = new ArrayList<>();

            // 查询用户权限关系表，获取对应的权限id
            RoleAuthorityExample example = new RoleAuthorityExample();
            RoleAuthorityExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(role.getRoleId());

            List<RoleAuthorityKey> roleAuthorityList = roleAuthorityMapper.selectByExample(example);

            for (RoleAuthorityKey roleAuthority : roleAuthorityList) {
                // 查询权限信息
                Authority authority = authorityMapper.selectByPrimaryKey(roleAuthority.getAuthorityId());
                authorityList.add(authority);
            }

            // 查询角色部门中间表，获取部门id
            RoleDepartmentExample roleDepartmentExample = new RoleDepartmentExample();
            RoleDepartmentExample.Criteria roleDepartmentExampleCriteria = roleDepartmentExample.createCriteria();
            roleDepartmentExampleCriteria.andRoleIdEqualTo(role.getRoleId());
            List<RoleDepartmentKey> roleDepartmentKeyList = roleDepartmentMapper.selectByExample(roleDepartmentExample);

            // 查询对应的部门
            List<Department> departmentList = new ArrayList<>();
            for (RoleDepartmentKey roleDepartmentKey : roleDepartmentKeyList) {
                Department department = departmentMapper.selectByPrimaryKey(roleDepartmentKey.getDeptId());
                departmentList.add(department);
            }

            // 封装数据
            RoleBean roleBean = new RoleBean();
            BeanUtils.copyProperties(role, roleBean);
            roleBean.setAuthorityList(authorityList);
            roleBean.setDepartmentList(departmentList);
            roleBeanList.add(roleBean);
        }

        return roleBeanList;
    }

    /**
     * 根据用户账号查询角色列表
     * @param userAccount 用户账号
     * @return
     */
    @Override
    public List<Role> listRoleByUserAccount(String userAccount) {
        if (userAccount == null || userAccount.equals("")) {
            return null;
        }
        // 通过userAccount查询对应的角色
        User user = userService.getUser(userAccount);
        if (user == null) {
            return null;
        }
        // 通过userId查询对应的角色
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        List<UserRoleKey> userRoleKeyList = userRoleMapper.selectByExample(userRoleExample);

        List<Role> roleList = new ArrayList<>();
        for (UserRoleKey userRoleKey : userRoleKeyList) {
            Role role = roleMapper.selectByPrimaryKey(userRoleKey.getRoleId());
            roleList.add(role);
        }

        return roleList;
    }

    /**
     * 添加角色
     *
     * @param roleBean 返回的角色包装类
     */
    @Override
    public void saveRole(RoleBean roleBean) {
        if (roleBean == null) {
            return;
        }
        Role role = new Role();
        BeanUtils.copyProperties(roleBean, role);
        // 添加角色
        roleMapper.insert(role);

        // 新增角色编号
        Integer roleId = role.getRoleId();
        // 一个角色包含的所有权限
        List<Authority> authorityList = roleBean.getAuthorityList();
        // 根据角色 id 增加对应的权限表信息
        for (Authority authority : authorityList) {
            RoleAuthorityKey roleAuthority = new RoleAuthorityKey();
            roleAuthority.setRoleId(roleId);
            roleAuthority.setAuthorityId(authority.getAuthorityId());
            roleAuthorityMapper.insert(roleAuthority);
        }

        // 根据 id 增加对应的部门信息（中间表）
        List<Department> departmentList = roleBean.getDepartmentList();
        for (Department department : departmentList) {
            RoleDepartmentKey roleDepartmentKey = new RoleDepartmentKey();
            roleDepartmentKey.setRoleId(roleId);
            roleDepartmentKey.setDeptId(department.getDeptId());
            roleDepartmentMapper.insert(roleDepartmentKey);
        }
    }

    /**
     * 修改角色
     *
     * @param roleBean 角色信息
     */
    @Override
    public void updateRole(RoleBean roleBean) {
        if (roleBean == null) {
            return;
        }
        Role role = new Role();
        BeanUtils.copyProperties(roleBean, role);
        // 修改角色
        roleMapper.updateByPrimaryKey(role);

        // 要修改的角色编号
        Integer roleId = roleBean.getRoleId();
        // 一个角色将要修改的所有权限
        List<Authority> authorityList = roleBean.getAuthorityList();

        // 先删除所有权限
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        RoleAuthorityExample.Criteria roleAuthorityExampleCriteria = roleAuthorityExample.createCriteria();
        roleAuthorityExampleCriteria.andRoleIdEqualTo(roleId);
        roleAuthorityMapper.deleteByExample(roleAuthorityExample);

        // 根据角色 id 添加对应的权限表信息
        for (Authority authority : authorityList) {
            RoleAuthorityKey roleAuthority = new RoleAuthorityKey();
            roleAuthority.setRoleId(roleId);
            roleAuthority.setAuthorityId(authority.getAuthorityId());
            roleAuthorityMapper.insert(roleAuthority);
        }

        // 先删除角色对应的部门
        RoleDepartmentExample roleDepartmentExample = new RoleDepartmentExample();
        RoleDepartmentExample.Criteria roleDepartmentExampleCriteria = roleDepartmentExample.createCriteria();
        roleDepartmentExampleCriteria.andRoleIdEqualTo(roleId);
        roleDepartmentMapper.deleteByExample(roleDepartmentExample);

        // 再添加角色对应的部门
        List<Department> departmentList = roleBean.getDepartmentList();
        for (Department department : departmentList) {
            RoleDepartmentKey roleDepartmentKey = new RoleDepartmentKey();
            roleDepartmentKey.setRoleId(roleId);
            roleDepartmentKey.setDeptId(department.getDeptId());
            roleDepartmentMapper.insert(roleDepartmentKey);
        }
    }

    /**
     * 删除角色
     *
     * @param roleId 角色id
     */
    @Override
    public void removeRole(Integer roleId) {
        if (roleId == null) {
            return;
        }
        // 删除角色信息
        roleMapper.deleteByPrimaryKey(roleId);
        // 删除对应权限
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        RoleAuthorityExample.Criteria roleAuthorityExampleCriteria = roleAuthorityExample.createCriteria();
        roleAuthorityExampleCriteria.andRoleIdEqualTo(roleId);
        roleAuthorityMapper.deleteByExample(roleAuthorityExample);
        // 删除对应部门
        RoleDepartmentExample roleDepartmentExample = new RoleDepartmentExample();
        RoleDepartmentExample.Criteria roleDepartmentExampleCriteria = roleDepartmentExample.createCriteria();
        roleDepartmentExampleCriteria.andRoleIdEqualTo(roleId);
        roleDepartmentMapper.deleteByExample(roleDepartmentExample);
        // 删除用户角色中间表中相应的角色
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        userRoleMapper.deleteByExample(userRoleExample);
    }
}
