package com.tianyi.system.service.impl;

import com.tianyi.system.entity.Role;
import com.tianyi.system.service.IRoleService;
import com.tianyi.system.vo.RoleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author : LiYong
 * @program : RoleServiceImplTest
 * @description :
 * @date : 2019/9/8 17:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class RoleServiceImplTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void test01() {
        // 查询所有角色
        List<RoleBean> roleList = roleService.listRole();
        System.out.println(roleList);
    }

}