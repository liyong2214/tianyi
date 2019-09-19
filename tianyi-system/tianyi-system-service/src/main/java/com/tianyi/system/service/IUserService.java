package com.tianyi.system.service;

import com.tianyi.system.entity.User;
import com.tianyi.system.vo.UserBean;

import java.util.List;

/**
 * @author : LiYong
 * @program : UserService
 * @description :
 * @date : 2019/9/7 23:29
 */
public interface IUserService {

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<UserBean> listUser();

    /**
     * 添加用户
     */
    void saveUser(UserBean userBean);

    /**
     * 通过用户查找是否存在该用户
     * @param userAccount 用户名
     * @return 用户
     */
    User getUser(String userAccount);

    /**
     * 按条件查询用户列表
     * @param userBean 查询条件
     * @return 用户列表
     */
    List<UserBean> listUserByCondition(UserBean userBean);

    /**
     * 修改用户
     * @param userBean 新用户信息
     */
    void updateUser(UserBean userBean);

    /**
     * 删除用户
     * @param userId 用户编号
     */
    void removeUser(long userId);
}
