package com.tianyi.system.service.impl;

import com.tianyi.system.entity.User;
import com.tianyi.system.service.IUserService;
import com.tianyi.system.vo.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author : LiYong
 * @program : UserServiceImplTest
 * @description :
 * @date : 2019/9/8 11:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;


    @Test
    public void test01() {
        // 添加用户
        User user = new User();
        user.setUserAccount("zhaoqi");
        user.setUserName("赵七");
        user.setDeptId(1);
        user.setUserPassword("143244");
        user.setUserSex(1);
        user.setUserState(0);
        user.setDutyId(2);
        user.setUserPhone("212333333335");
        user.setUserEmail("12345@sina.com");
        user.setUserIp("3");

        /*int i = userService.saveUser(user);
        System.out.println(i);
        System.out.println(user.getUserId());*/
    }

    @Test
    public void test02() {
        // 查询单个用户是否存在
        User user = userService.getUser("zhangsan");
        System.out.println(user);
    }

    @Test
    public void test03() {
        // 条件查询用户列表
        UserBean user = new UserBean();
//        user.setUserAccount("lisi");
//        user.setUserName("李");
        /*user.setDeptId(1);
        user.setUserSex(1);
        user.setUserState(1);
        user.setDutyId(1);*/

        List<UserBean> userBeanList = userService.listUserByCondition(user);

        System.out.println(userBeanList.size());
        System.out.println(userBeanList);
    }

    @Test
    public void test04() {
        // 查询所有用户
        List<UserBean> userBeanList = userService.listUser();
        userBeanList.forEach(System.out::println);
    }
}