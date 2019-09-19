package com.tianyi.goods.service.impl;

import com.tianyi.goods.entity.Role;
import com.tianyi.goods.entity.User;
import com.tianyi.goods.entity.UserRoleExample;
import com.tianyi.goods.entity.UserRoleKey;
import com.tianyi.goods.mapper.UserRoleMapper;
import com.tianyi.goods.service.IUserRoleService;
import com.tianyi.goods.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: tianyi
 * @description: IUserRoleService实现类
 * @author: Simon
 * @create: 2019-09-10 23:10
 **/

@Service
@Transactional
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private IUserService userService;


    /**
     * @param userId 用户id
     * @return
     */
    @Override
    public Set<Integer> findRolesByUserId(Long userId) {
        Set<Integer> roleIdSet = new HashSet<>();
        if (userId == null) {
            return null;
        }
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(userRoleExample);

        for (UserRoleKey userRoleKey : userRoleKeys) {
            roleIdSet.add(userRoleKey.getRoleId());
        }
        return roleIdSet;
    }

    /**
     * <h2>依据roleid查询出该role下的所有的user</h2>
     *
     * @param roleId {角色id}
     * @return
     */
    @Override
    public Set<User> findUsersByRoleId(Integer roleId) {
        Set<User> userSet = new HashSet<>();

        if (roleId == null) {

            return userSet;
        }
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);

        List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(userRoleExample);


        for (UserRoleKey userRoleKey : userRoleKeys) {
            User user = userService.selectUserByUserId(userRoleKey.getUserId());
            System.out.println(user);
            userSet.add(user);

        }
        return userSet;
    }
}
