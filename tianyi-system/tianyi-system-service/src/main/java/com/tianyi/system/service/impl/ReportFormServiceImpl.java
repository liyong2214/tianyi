package com.tianyi.system.service.impl;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Operation;
import com.tianyi.system.entity.Role;
import com.tianyi.system.service.*;
import com.tianyi.system.vo.UserBean;
import com.tianyi.system.vo.UserRoleAuthorityBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : LiYong
 * @program : ReportFormServiceImpl
 * @description : 报表实现类
 * @date : 2019/9/13 15:00
 */
@Service
@Transactional
public class ReportFormServiceImpl implements IReportFormService {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IAuthorityService authorityService;

    @Autowired
    IOperationService operationService;

    /**
     * 权限报表
     *
     * @return
     */
    @Override
    public List<UserRoleAuthorityBean> listUserForm(UserBean userBean) {
        if (userBean == null) {
            userBean = new UserBean();
        }
        // 查询用户
        List<UserBean> userBeanList = userService.listUserByCondition(userBean);
        // 返回的实体类
        List<UserRoleAuthorityBean> userRoleAuthorityBeanList = new ArrayList<>();

        // 封装到UserRoleAuthorityBean
        for (UserBean bean : userBeanList) {
            UserRoleAuthorityBean userRoleAuthorityBean = new UserRoleAuthorityBean();
            BeanUtils.copyProperties(bean, userRoleAuthorityBean);  // 复制用户信息
            // 角色列表
            List<Role> roleList = bean.getRoleList();
            Set<Role> roles = new HashSet<>(roleList);
            userRoleAuthorityBean.setRoles(roles);  // 封装角色信息

            // 查询权限
            Set<Authority> authorities = new HashSet<>();
            for (Role role : roles) {
                // 根据角色查询权限
                List<Authority> authorityList = authorityService.listAuthorityByRole(role);
                authorities.addAll(authorityList);
            }
            userRoleAuthorityBean.setAuthorities(authorities);  // 封装权限信息

            // 查询权限范围（操作）
            Set<Operation> operations = new HashSet<>();
            for (Authority authority : authorities) {
                List<Operation> operationList = operationService.listOperation(authority);
                operations.addAll(operationList);
            }
            userRoleAuthorityBean.setOperations(operations);    // 封装权限操作

            userRoleAuthorityBeanList.add(userRoleAuthorityBean);
        }

        return userRoleAuthorityBeanList;
    }
}
