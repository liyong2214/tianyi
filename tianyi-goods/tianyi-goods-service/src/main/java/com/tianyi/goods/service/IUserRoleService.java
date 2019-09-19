package com.tianyi.goods.service;

import com.tianyi.goods.entity.Role;
import com.tianyi.goods.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @program: tianyi
 * @description: 用户、角色中间表
 * @author: Simon
 * @create: 2019-09-10 23:06
 **/
public interface IUserRoleService {


    /**
     * @param userId 用户id
     * @return 角色id集合
     */
    Set<Integer> findRolesByUserId(Long userId);


    /**
     * @param roleId {角色id}
     * @return 用户集合
     */
    Set<User> findUsersByRoleId(Integer roleId);
}
