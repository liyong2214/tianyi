package com.tianyi.trade.service.impl;

import com.tianyi.trade.model.VO.DeliveryOrderInfoVO;
import com.tianyi.trade.model.VO.DeliveryVO;
import com.tianyi.trade.service.ITradeDeliverRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : Hens
 * @date : 2019/9/16 20:07
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class TradeDeliverRecordServiceImplTest {
    @Autowired
    private ITradeDeliverRecordService tradeDeliverRecordService;

    /**
     * 分页查看订单记录
     */
    @Test
    public void listDelivery() {
        List<DeliveryVO> deliveryVOS = tradeDeliverRecordService.listDelivery(1, 5);
        deliveryVOS.forEach(System.out::println);
    }

    @Test
    public void getDelivery() {
        DeliveryOrderInfoVO delivery = tradeDeliverRecordService.getDelivery(27L);
        System.out.println(delivery);
    }
}