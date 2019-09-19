package com.tianyi.system.service.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : LiYong
 * @program : LogTest
 * @description : 日志测试
 * @date : 2019/9/10 22:56
 */
public class LogTest {

    @Test
    public void testSlf4j() {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.error("3333");
        logger.info("日志测试");
    }
}
