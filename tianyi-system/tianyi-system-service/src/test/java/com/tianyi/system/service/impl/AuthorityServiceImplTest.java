package com.tianyi.system.service.impl;

import com.tianyi.system.service.IAuthorityService;
import com.tianyi.system.vo.AuthorityBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : LiYong
 * @program : AuthorityServiceImplTest
 * @description :
 * @date : 2019/9/10 11:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class AuthorityServiceImplTest {

    @Autowired
    private IAuthorityService authorityService;

    @Test
    public void test01() {
        List<AuthorityBean> authorityBeanList = authorityService.listAuthority();
        System.out.println(authorityBeanList);
    }
}