package com.tianyi.system.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * @author : LiYong
 * @program : JedisUtil2Test
 * @description :
 * @date : 2019/9/14 10:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-jedis.xml"})
public class JedisUtil2Test {

    @Autowired
    private JedisUtil jedisUtil;

    @Test
    public void test01() {
        Jedis jedis = jedisUtil.getResouce();
        String set = jedis.set("name", "小明");
        String name = jedis.get("name");
        System.out.println(set);
        System.out.println(name);
        jedisUtil.release(jedis);
    }
}