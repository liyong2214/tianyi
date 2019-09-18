package com.tianyi.trade.service.impl;

import com.tianyi.trade.model.VO.GoDownEntryVO;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeReturnService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 退货单
 * @author : Hens
 * @date : 2019/9/16 20:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class TradeReturnServiceImplTest {
    @Autowired
    private ITradeReturnService tradeReturnService;

    /**
     * 分页查看退货单
     */
    @Test
    public void listReturnOrder() {
        List<OrderVO> orderVOList = tradeReturnService.listReturnOrder(1, 5);
        orderVOList.forEach(System.out::println);
    }

    /**
     * 生成退货单详情信息
     */
    @Test
    public void getReturnOrderInfo() {
        GoDownEntryVO goDownEntryVO = tradeReturnService.getGoDownEntryVO(27L);
        System.out.println(goDownEntryVO);
    }

    /**
     * 查看信息退货单
     */
    @Test
    public void getGoDownEntryVO() {
        OrderInfoVO returnOrderInfo = tradeReturnService.getReturnOrderInfo(  27L);
        System.out.println(returnOrderInfo);
    }
}