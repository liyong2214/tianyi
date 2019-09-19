package com.tianyi.system.service.impl;

import com.tianyi.system.entity.*;
import com.tianyi.system.mapper.*;
import com.tianyi.system.service.IUserService;
import com.tianyi.system.vo.UserBean;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : LiYong
 * @program : UserServiceImpl
 * @description : UserService实现类
 * @date : 2019/9/7 23:30
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DutyMapper dutyMapper;

    @Autowired
    private IpMapper ipMapper;

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Override
    public List<UserBean> listUser() {
        // 查询用户列表
        List<User> userList = userMapper.selectByExample(null);
        return getUserBeanList(userList);
    }

    // 根据用户信息查询对应的角色信息
    private List<UserBean> getUserBeanList(List<User> userList) {
        if (userList.size() == 0) {
            return null;
        }
        // 存储UserBean
        List<UserBean> userBeanList = new ArrayList<>();
        // 查询对应的角色列表
        for (User user : userList) {
            // 存放角色列表
            List<Role> roleList = new ArrayList<>();

            UserRoleExample userRoleExample = new UserRoleExample();
            UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
            criteria.andUserIdEqualTo(user.getUserId());

            // 查询角色id
            List<UserRoleKey> userRoleKeyList = userRoleMapper.selectByExample(userRoleExample);
            // 查询角色信息放入UserBean
            for (UserRoleKey userRoleKey : userRoleKeyList) {
                Role role = roleMapper.selectByPrimaryKey(userRoleKey.getRoleId());
                roleList.add(role);
            }

            // 查询用户的部门、职务、ip的名称
            Map<String, String> map = getDeptDutyIpName(user);

            UserBean userBean = new UserBean();
            BeanUtils.copyProperties(user, userBean);
            userBean.setRoleList(roleList);  // 封装角色
            userBean.setDeptName(map.get("deptName"));
            userBean.setDutyName(map.get("dutyName"));
            userBean.setIpName(map.get("ipName"));
            // 放到返回的集合中
            userBeanList.add(userBean);
        }
        return userBeanList;
    }

    // 查询用户的部门、职务、ip的名称
    private Map<String, String> getDeptDutyIpName(User user) {
        Map<String, String> map = new HashMap<>();
        // 查询部门名称
        Department department = departmentMapper.selectByPrimaryKey(user.getDeptId());
        map.put("deptName", department.getDeptName());
        // 查询职务名称
        Duty duty = dutyMapper.selectByPrimaryKey(user.getDutyId());
        map.put("dutyName", duty.getDutyName());
        // 查询ip名称
        Ip ip = ipMapper.selectByPrimaryKey(Integer.parseInt(user.getUserIp()));
        map.put("ipName", ip.getIpScope());

        return map;
    }

    /**
     * 添加用户
     *
     * @param userBean
     */
    @Override
    public void saveUser(UserBean userBean) {
        if (userBean == null) {
            return;
        }
        // 添加用户
        User user = new User();
        BeanUtils.copyProperties(userBean, user);
        // md5 加密， 这里没有使用盐
        String password = user.getUserPassword();
        String newPassword = new Md5Hash(password).toString();
        user.setUserPassword(newPassword);
        userMapper.insert(user);
        // 用户对应的角色信息
        List<Role> roleList = userBean.getRoleList();
        // 添加用户角色中间表
        for (Role role : roleList) {
            UserRoleKey userRoleKey = new UserRoleKey();
            userRoleKey.setRoleId(role.getRoleId());
            userRoleKey.setUserId(user.getUserId());
            userRoleMapper.insert(userRoleKey);
        }
    }

    /**
     * 通过用户查找是否存在该用户
     *
     * @param userAccount 用户名
     * @return 用户
     */
    @Override
    public User getUser(String userAccount) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(userAccount);
        List<User> users = userMapper.selectByExample(example);
        if (users == null || users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }
    }

    /**
     * 按条件查询用户列表
     *
     * @param userBean 查询条件
     * @return 用户列表
     */
    @Override
    public List<UserBean> listUserByCondition(UserBean userBean) {

        User user = new User();
        BeanUtils.copyProperties(userBean, user);

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();


        String userAccount = user.getUserAccount();  // 用户名
        Integer deptId = user.getDeptId();  // 用户部门
        Integer userState = user.getUserState();  // 用户状态
        Integer dutyId = user.getDutyId();  // 用户职务
        String userName = user.getUserName();  // 用户名
        Integer userSex = user.getUserSex();  // 用户性别

        if (userAccount != null) {
            criteria.andUserAccountLike("%" + userAccount + "%");
        }
        if (deptId != null) {
            criteria.andDeptIdEqualTo(deptId);
        }
        if (userState != null) {
            criteria.andUserStateEqualTo(userState);
        }
        if (dutyId != null) {
            criteria.andDutyIdEqualTo(dutyId);
        }
        if (userSex != null) {
            criteria.andUserSexEqualTo(userSex);
        }
        if (userName != null) {
            criteria.andUserNameLike("%" + userName + "%");
        }

        List<User> userList = userMapper.selectByExample(example);
        return getUserBeanList(userList);
    }

    /**
     * 修改用户
     *
     * @param userBean 新用户信息
     */
    @Override
    public void updateUser(UserBean userBean) {
        if (userBean == null) {
            return;
        }
        User user = new User();
        BeanUtils.copyProperties(userBean, user);
        String password = user.getUserPassword();
        if (password != null && !password.equals("")) {
            String newPassword = new Md5Hash(password).toString();
            user.setUserPassword(newPassword);
        }
        // 修改用户
        userMapper.updateByPrimaryKey(user);
        // 修改中间表
        List<Role> roleList = userBean.getRoleList();
        // 先删除
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userBean.getUserId());
        userRoleMapper.deleteByExample(userRoleExample);
        // 再添加
        for (Role role : roleList) {
            UserRoleKey userRoleKey = new UserRoleKey();
            userRoleKey.setUserId(userBean.getUserId());
            userRoleKey.setRoleId(role.getRoleId());
            userRoleMapper.insert(userRoleKey);
        }
    }

    /**
     * 删除用户
     *
     * @param userId 用户编号
     */
    @Override
    public void removeUser(long userId) {
        if (userId <= 0) {
            return;
        }
        // 删除用户
        userMapper.deleteByPrimaryKey(userId);
        // 删除中间表
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        userRoleMapper.deleteByExample(userRoleExample);
    }
}
