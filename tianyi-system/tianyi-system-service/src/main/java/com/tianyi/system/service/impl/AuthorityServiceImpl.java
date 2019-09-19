package com.tianyi.system.service.impl;

import com.tianyi.system.entity.*;
import com.tianyi.system.mapper.AuthorityMapper;
import com.tianyi.system.mapper.AuthorityOperationMapper;
import com.tianyi.system.mapper.OperationMapper;
import com.tianyi.system.mapper.RoleAuthorityMapper;
import com.tianyi.system.service.IAuthorityService;
import com.tianyi.system.service.IOperationService;
import com.tianyi.system.vo.AuthorityBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiYong
 * @program : AuthorityServiceImpl
 * @description : 权限实现类
 * @date : 2019/9/10 11:01
 */
@Service
@Transactional
public class AuthorityServiceImpl implements IAuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private AuthorityOperationMapper authorityOperationMapper;

    @Autowired
    private OperationMapper operationMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private IOperationService operationService;

    /**
     * 查询所有权限
     *
     * @return 权限列表
     */
    @Override
    public List<AuthorityBean> listAuthority() {
        // 权限所有权限
        List<Authority> authorityList = authorityMapper.selectByExample(null);
        // 查询权限可执行的操作
        List<AuthorityBean> authorityBeanList = new ArrayList<>();
        for (Authority authority : authorityList) {
            // 查询权限列表
            List<Operation> operationList = operationService.listOperation(authority);
            // 封装信息
            AuthorityBean authorityBean = new AuthorityBean();
            BeanUtils.copyProperties(authority,authorityBean);
            authorityBean.setOperationList(operationList);
            authorityBeanList.add(authorityBean);
        }

        return authorityBeanList;
    }

    @Override
    public List<Authority> listAuthorityByRole(Role role) {
        // 查询中间表
        RoleAuthorityExample authorityExample = new RoleAuthorityExample();
        RoleAuthorityExample.Criteria criteria = authorityExample.createCriteria();
        criteria.andRoleIdEqualTo(role.getRoleId());
        List<RoleAuthorityKey> roleAuthorityKeyList = roleAuthorityMapper.selectByExample(authorityExample);
        // 查询权限信息
        List<Authority> authorityList = new ArrayList<>();
        for (RoleAuthorityKey roleAuthorityKey : roleAuthorityKeyList) {
            Authority authority = authorityMapper.selectByPrimaryKey(roleAuthorityKey.getAuthorityId());
            authorityList.add(authority);
        }
        return authorityList;
    }

    /**
     * 添加权限
     *
     * @param authorityBean 新增信息
     */
    @Override
    public void saveAuthority(AuthorityBean authorityBean) {
        // 新增权限
        authorityMapper.insert(authorityBean);
        // 新增id
        Integer authorityId = authorityBean.getAuthorityId();
        // 新增对应的操作中间表
        List<Operation> operationList = authorityBean.getOperationList();
        for (Operation operation : operationList) {
            AuthorityOperationKey authorityOperationKey = new AuthorityOperationKey();
            authorityOperationKey.setAuthorityId(authorityId);
            authorityOperationKey.setOperationId(operation.getOperationId());
            authorityOperationMapper.insert(authorityOperationKey);
        }
    }

    /**
     * 修改权限
     *
     * @param authorityBean 修改信息
     */
    @Override
    public void updateAuthority(AuthorityBean authorityBean) {
        // 修改权限表
        authorityMapper.updateByPrimaryKey(authorityBean);
        // 修改权限操作表
        // 先删除
        AuthorityOperationExample authorityOperationExample = new AuthorityOperationExample();
        AuthorityOperationExample.Criteria criteria = authorityOperationExample.createCriteria();
        criteria.andAuthorityIdEqualTo(authorityBean.getAuthorityId());
        authorityOperationMapper.deleteByExample(authorityOperationExample);

        // 再添加
        List<Operation> operationList = authorityBean.getOperationList();
        for (Operation operation : operationList) {
            AuthorityOperationKey authorityOperationKey = new AuthorityOperationKey();
            authorityOperationKey.setAuthorityId(authorityBean.getAuthorityId());
            authorityOperationKey.setOperationId(operation.getOperationId());
            authorityOperationMapper.insert(authorityOperationKey);
        }
    }

    /**
     * 删除权限
     *
     * @param authorityId 权限id
     */
    @Override
    public void deleteAuthority(Integer authorityId) {
        // 删除权限表
        authorityMapper.deleteByPrimaryKey(authorityId);
        // 删除权限操作表
        AuthorityOperationExample authorityOperationExample = new AuthorityOperationExample();
        AuthorityOperationExample.Criteria criteria = authorityOperationExample.createCriteria();
        criteria.andAuthorityIdEqualTo(authorityId);
        authorityOperationMapper.deleteByExample(authorityOperationExample);
        // 删除角色权限表，删除权限后，角色也没有此权限了
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        RoleAuthorityExample.Criteria criteria1 = roleAuthorityExample.createCriteria();
        criteria1.andAuthorityIdEqualTo(authorityId);
        roleAuthorityMapper.deleteByExample(roleAuthorityExample);
    }
}
