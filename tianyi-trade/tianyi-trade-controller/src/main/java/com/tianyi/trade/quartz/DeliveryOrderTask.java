package com.tianyi.trade.quartz;

import com.tianyi.trade.service.ITradeDeliverOrderService;
import com.tianyi.trade.service.ITradeOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 每天定期产生销售出库单
 * @author : Hens
 * @date : 2019/9/10 16:05
 */
public class DeliveryOrderTask {
    @Autowired
    private ITradeDeliverOrderService tradeDeliverOrderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryOrderTask.class);

    public void generateDeliveryOrder(){
        Integer integer = tradeDeliverOrderService.saveTradeDeliverOrder(null);
        LOGGER.info("产生了 integer: [{}]张销售出库单",integer);
    }

}
