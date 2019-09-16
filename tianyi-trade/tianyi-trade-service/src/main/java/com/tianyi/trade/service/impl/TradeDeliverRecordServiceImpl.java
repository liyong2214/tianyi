package com.tianyi.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.tianyi.trade.constant.StateEnum;
import com.tianyi.trade.mapper.*;
import com.tianyi.trade.model.*;
import com.tianyi.trade.model.VO.DeliveryOrderInfoVO;
import com.tianyi.trade.model.VO.DeliveryVO;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.service.ITradeDeliverRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 销售出库记录实现类
 * @author : Hens
 * @date : 2019/9/12 17:52
 */
@Service
public class TradeDeliverRecordServiceImpl implements ITradeDeliverRecordService {

    private final TradeOrderMapper tradeOrderMapper;
    private final TradeExpressinfoMapper tradeExpressinfoMapper;
    private final TradeDeliveryMapper tradeDeliveryMapper;
    private final TradeOrderinfoMapper tradeOrderinfoMapper;

    @Autowired
    public TradeDeliverRecordServiceImpl(TradeOrderMapper tradeOrderMapper, TradeExpressinfoMapper tradeExpressinfoMapper, TradeDeliveryMapper tradeDeliveryMapper, TradeOrderinfoMapper tradeOrderinfoMapper) {
        this.tradeOrderMapper = tradeOrderMapper;
        this.tradeExpressinfoMapper = tradeExpressinfoMapper;
        this.tradeDeliveryMapper = tradeDeliveryMapper;
        this.tradeOrderinfoMapper = tradeOrderinfoMapper;

    }

    /**
     *  分页显示
     * @param currentPage 当前数据
     * @param pageSize 当前页显示数据量
     * @return 销售出库单记录
     */
    @Override
    public List<DeliveryVO> listDelivery(int currentPage, int pageSize) {
        List<DeliveryVO> deliveryVOS = new ArrayList<>(pageSize);
        // 获取分页订单
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        tradeOrderExample.createCriteria().andOrderStateBetween(StateEnum.PASSED.getState(),StateEnum.PAID.getState());
        PageHelper.startPage(currentPage,pageSize);
        List<TradeOrder> tradeOrders = tradeOrderMapper.selectByExample(tradeOrderExample);
        if(tradeOrders.isEmpty()){
            return Collections.emptyList();
        }
        // 根据订单id查询相关的快递单数据
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        DeliveryVO deliveryVO = new DeliveryVO();
        for (TradeOrder tradeOrder : tradeOrders) {
            Long orderId = tradeOrder.getOrderId();
            BeanUtils.copyProperties(tradeOrder, deliveryVO);
            // 将快递信息传递
            tradeExpressinfoExample.clear();
            tradeExpressinfoExample.createCriteria().andOrderIdEqualTo(orderId);
            List<TradeExpressinfo> tradeExpressinfos = tradeExpressinfoMapper.selectByExample(tradeExpressinfoExample);
            TradeExpressinfo tradeExpressinfo = tradeExpressinfos.get(0);
            BeanUtils.copyProperties(tradeExpressinfo, deliveryVO);
            deliveryVOS.add(deliveryVO);
        }
        return deliveryVOS;
    }

    /**
     * 查看销售出库单详情
     * @param id 销售出库单编号
     * @return 销售出库单详情
     */
    @Override
    public DeliveryOrderInfoVO getDelivery(Long id) {
        DeliveryOrderInfoVO deliveryInfoVO = new DeliveryOrderInfoVO();
        // 根据id 查询order信息
        TradeOrder tradeOrder = tradeOrderMapper.selectByPrimaryKey(id);
        if(tradeOrder == null){
            return null;
        }
        BeanUtils.copyProperties(tradeOrder,deliveryInfoVO);
        // 查询orderinfo商品信息
        Long orderId = tradeOrder.getOrderId();
        TradeOrderinfoExample tradeOrderinfoExample = new TradeOrderinfoExample();
        tradeOrderinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeOrderinfo> tradeOrderinfos = tradeOrderinfoMapper.selectByExample(tradeOrderinfoExample);
        deliveryInfoVO.setTradeOrderinfos(tradeOrderinfos);
        // 查询快递信息
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        tradeExpressinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeExpressinfo> tradeExpressinfos = tradeExpressinfoMapper.selectByExample(tradeExpressinfoExample);
        BeanUtils.copyProperties(tradeExpressinfos.get(0),deliveryInfoVO);
        // 查询创建人和时间
        TradeDeliveryExample tradeDeliveryExample = new TradeDeliveryExample();
        tradeDeliveryExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeDelivery> tradeDeliveries = tradeDeliveryMapper.selectByExample(tradeDeliveryExample);
        TradeDelivery tradeDelivery = tradeDeliveries.get(0);
        BeanUtils.copyProperties(tradeDelivery,deliveryInfoVO);
        return deliveryInfoVO;
    }
}
