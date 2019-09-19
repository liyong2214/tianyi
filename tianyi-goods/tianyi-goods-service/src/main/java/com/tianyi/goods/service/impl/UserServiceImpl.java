package com.tianyi.goods.service.impl;

import com.tianyi.goods.entity.User;
import com.tianyi.goods.entity.UserExample;
import com.tianyi.goods.mapper.UserMapper;
import com.tianyi.goods.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tianyi
 * @description:
 * @author: Simon
 * @create: 2019-09-10 20:22
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @param account  账号
     * @param password 密码
     * @return
     */
    @Override
    public User selectUserByAccount(String account, String password) {

        if (account == null || password == null) {
            return null;

        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserAccountEqualTo(account);
        criteria.andUserPasswordEqualTo(password);

        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            return null;
        }

        return users.get(0);
    }

    /**
     * @param userId {用户id }
     * @return {@link User}
     */
    @Override
    public User selectUserByUserId(Long userId) {
        if (userId == null) {
            return null;
        }


        return userMapper.selectByPrimaryKey(userId);
    }
}
