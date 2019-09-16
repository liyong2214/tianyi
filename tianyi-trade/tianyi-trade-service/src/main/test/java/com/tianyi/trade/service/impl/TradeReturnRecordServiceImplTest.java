package com.tianyi.trade.service.impl;

import com.tianyi.trade.model.VO.TradeReturnOrderVO;
import com.tianyi.trade.model.VO.TradeReturnVO;
import com.tianyi.trade.service.ITradeReturnRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : Hens
 * @date : 2019/9/16 20:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class TradeReturnRecordServiceImplTest {
    @Autowired
    private ITradeReturnRecordService tradeReturnRecordService;

    /**
     * 查看退货单记录
     */
    @Test
    public void listReturnVO() {
        List<TradeReturnVO> tradeReturnVOS = tradeReturnRecordService.listReturnVO(1, 5);
        tradeReturnVOS.forEach(System.out::println);
    }

    /**
     * 查看详情
     */
    @Test
    public void getReturnOrder() {
        TradeReturnOrderVO returnOrder = tradeReturnRecordService.getReturnOrder(1L);
        System.out.println(returnOrder);
    }
}