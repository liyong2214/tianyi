package com.tianyi.trade.controller;


import com.tianyi.trade.model.TradeOrderinfo;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.model.VO.TradeOrderVO;
import com.tianyi.trade.service.ITradeOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/8 13:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class TradeControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeControllerTest.class);
    @Autowired
    private ITradeOrderService tradeOrderService;

    /**
     * 测试接收天翼订单信息
     */
    @Test
    public void receiveOrderTest(){
        TradeOrderVO tradeOrderVO = new TradeOrderVO();
        tradeOrderVO.setActionId(0);
        tradeOrderVO.setCreateTime(new Date());
        tradeOrderVO.setExpressAddress("郑州");
        tradeOrderVO.setExpressCost(5L);
        tradeOrderVO.setExpressType(0);
        tradeOrderVO.setNote("正常");
        tradeOrderVO.setOrderId(1000L);
        tradeOrderVO.setOrderState(0);
        tradeOrderVO.setPayType(0);
        tradeOrderVO.setPostcode("510000");
        tradeOrderVO.setReceiver("小李");
        tradeOrderVO.setReceiverAddress("郑州");
        tradeOrderVO.setReceiverContact("15555555555");
        tradeOrderVO.setReceiverEmail("88888888@qq.com");
        tradeOrderVO.setReceiverMobile("88888888");
        tradeOrderVO.setReceiveTime(new Date());
        tradeOrderVO.setRemitter("小李");
        tradeOrderVO.setResourceId(1);
        tradeOrderVO.setTypeId(1);
        tradeOrderVO.setTradeType(1);
        tradeOrderVO.setUsername("tianyi001");
        tradeOrderVO.setExpressId(1000000L);
        List<TradeOrderinfo> tradeOrderinfos = new ArrayList<>();
        TradeOrderinfo tradeOrderinfo = new TradeOrderinfo();
        tradeOrderinfo.setOrderId(1000L);
        tradeOrderinfo.setGoodsId(1001L);
        tradeOrderinfo.setCreateTime(new Date());
        tradeOrderinfo.setGoodsAmount(1);
        tradeOrderinfo.setUpdateTime(new Date());
        tradeOrderinfo.setGoodsName("三星");
        tradeOrderinfo.setGoodsPrice(1500L);
        tradeOrderinfo.setGoodsTotal(1000L);
        tradeOrderinfos.add(tradeOrderinfo);

        tradeOrderVO.setTradeOrderinfos(tradeOrderinfos);
        Integer integer = tradeOrderService.saveOrder(tradeOrderVO);
        System.out.println(integer);
    }
    /**
     * 测试查询分页
     */
    @Test
    public void listOrder(){
        List<OrderVO> orderVOList = tradeOrderService.listOrderVO(1, 5);
        orderVOList.forEach(System.out::println);
    }

    /**
     * 测试查询订单
     */
    @Test
    public void getOrder(){
        OrderInfoVO orderInfo = tradeOrderService.getOrderInfo(27L);
        System.out.println(orderInfo);
    }

}