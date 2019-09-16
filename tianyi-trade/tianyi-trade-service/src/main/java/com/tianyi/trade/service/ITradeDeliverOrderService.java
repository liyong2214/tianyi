package com.tianyi.trade.service;

import com.tianyi.trade.model.VO.DeliveryOrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;

import java.util.List;

/**
 * 销售出库管理
 * @author : Hens
 * @date : 2019/9/11 16:06
 */
public interface ITradeDeliverOrderService {
    /**
     * 生成指定销售出库单
     * @param orderIds 指定的订单编号
     * @return 生成了多少出库单
     */
    public Integer saveTradeDeliverOrder(List<Long> orderIds);

    /**
     * 分页查询待出库订单
     * @param currentPage 当前数据
     * @param pageSize 页面显示数量
     * @return 订单分页信息
     */
    public List<OrderVO> listDeliverOrder(int currentPage,int pageSize);

}
