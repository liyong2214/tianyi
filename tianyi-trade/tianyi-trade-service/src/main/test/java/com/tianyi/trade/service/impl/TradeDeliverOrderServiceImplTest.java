package com.tianyi.trade.service.impl;

import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeDeliverOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/12 16:56
 */
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class TradeDeliverOrderServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeDeliverOrderServiceImplTest.class);
    @Autowired
    private ITradeDeliverOrderService tradeDeliverOrderService;

    // 分页显示测试
    @Test
    public void pageTest(){
        List<OrderVO> orderVOList = tradeDeliverOrderService.listDeliverOrder(1, 5);
        LOGGER.info("返回了[{}]条数据",orderVOList.size());
        orderVOList.forEach(System.out::println);
    }

    /**
     * 新增出库单
     */
    @Test
    public void saveDeliveryOrder() {
        List<Long> ids = new ArrayList<>();
        ids.add(1000L);
        Integer integer = tradeDeliverOrderService.saveTradeDeliverOrder(ids);
        System.out.println(integer);
    }
}