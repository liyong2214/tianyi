package com.tianyi.goods.service.impl;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.tianyi.goods.entity.Role;
import com.tianyi.goods.mapper.RoleMapper;
import com.tianyi.goods.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tianyi
 * @description: IRoleService实现类
 * @author: Simon
 * @create: 2019-09-10 23:25
 **/
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * @param id 角色id
     * @return
     */
    @Override
    public Role findById(Integer id) {

        if (id == null) {
            return null;
        }

        Role role = roleMapper.selectByPrimaryKey(id);


        return role;
    }
}
