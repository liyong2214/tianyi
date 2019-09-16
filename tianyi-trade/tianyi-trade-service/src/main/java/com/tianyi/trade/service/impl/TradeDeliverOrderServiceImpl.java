package com.tianyi.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.tianyi.trade.constant.StateEnum;
import com.tianyi.trade.mapper.TradeDeliveryMapper;
import com.tianyi.trade.mapper.TradeExpressinfoMapper;
import com.tianyi.trade.mapper.TradeOrderMapper;
import com.tianyi.trade.model.*;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeDeliverOrderService;
import com.tianyi.trade.service.ITradeOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 销售出库单管理
 * @author : Hens
 * @date : 2019/9/11 16:07
 */
@Service
public class TradeDeliverOrderServiceImpl implements ITradeDeliverOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeDeliverOrderServiceImpl.class);

    private final TradeOrderMapper tradeOrderMapper;
    private final TradeDeliveryMapper tradeDeliveryMapper;
    private final TradeExpressinfoMapper tradeExpressinfoMapper;

    @Autowired
    public TradeDeliverOrderServiceImpl(TradeOrderMapper tradeOrderMapper, TradeDeliveryMapper tradeDeliveryMapper, ITradeOrderService iTradeOrderService, TradeExpressinfoMapper tradeExpressinfoMapper) {
        this.tradeOrderMapper = tradeOrderMapper;
        this.tradeDeliveryMapper = tradeDeliveryMapper;
        this.tradeExpressinfoMapper = tradeExpressinfoMapper;
    }

    /**
     * 储存销售出库单（根据订单编号生成，多个或者没有就全部生成）
     * @param orderIds 订单编号
     * @return tradeDeliverOrderVO 返回已存入数据库的数量单
     */
    @Override
    public Integer saveTradeDeliverOrder(List<Long> orderIds) {
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        int result = 0;
        Date date = new Date();
        // 传入为空时，生成当天到前一天的出库单,用于定时生成
        if(orderIds.isEmpty()){
            // 全部生成根据日期到前一天当天
            long time = date.getTime();
            long lastTime = time - 24*60*60*1000L;
            Date lastDate = new Date();
            lastDate.setTime(lastTime);
            tradeOrderExample.createCriteria().andCreateTimeBetween(lastDate,date);
            List<TradeOrder> tradeOrders = tradeOrderMapper.selectByExample(tradeOrderExample);
            int total = tradeOrders.size();
            for (TradeOrder tradeOrder:tradeOrders) {
                tradeOrder.setUpdateTime(date);
                Long orderId = tradeOrder.getOrderId();
                result = getResult(tradeOrder,result, date, orderId);
            }
            LOGGER.info("一共传输了 total:[{}] 张销售订单，存入了 result ：[{}] 张",total,result);
            return result;
        }

        // 有传入值时获取订单编号，根据选择生成
        for (Long orderId: orderIds) {
            // 获取订单信息
            tradeOrderExample.createCriteria().andOrderIdEqualTo(orderId);
            List<TradeOrder> tradeOrders = tradeOrderMapper.selectByExample(tradeOrderExample);
            TradeOrder tradeOrder = tradeOrders.get(0);
            result = getResult(tradeOrder, result, date, orderId);
        }

        // 展示出库单信息
//        // 获取订单中的商品信息
//        TradeOrderinfoExample tradeOrderinfoExample = new TradeOrderinfoExample();
//        tradeOrderinfoExample.createCriteria().andOrderIdEqualTo(orderId);
//        List<TradeOrderinfo> tradeOrderinfos = tradeOrderinfoMapper.selectByExample(tradeOrderinfoExample);
//        // 品牌、型号、仓库、串码、供货商
//
//        BeanUtils.copyProperties(tradeOrderVO,tradeDeliverOrderVO);
//        // 获得订单id
//        Long orderId = tradeOrderVO.getOrderId();
//        // 查询该订单下所有商品的信息
//        TradeOrderinfoExample tradeOrderinfoExample = new TradeOrderinfoExample();
//        tradeOrderinfoExample.createCriteria().andOrderIdEqualTo(orderId);
//        List<TradeOrderinfo> tradeOrderinfos = tradeOrderinfoMapper.selectByExample(tradeOrderinfoExample);
//        // 新建数组用于存放商品信息
//        List<GoodDeliverVO> goodDeliverVOS = new ArrayList<>();
//        // 查询所有商品品牌
//        List<TGoodsBrand> tGoodsBrands = tGoodsBrandMapper.selectByExample(null);
//        TGoodsBrand tGoodsBrand = new TGoodsBrand();
//        // 查询订单中的商品信息
//        for (TradeOrderinfo tradeOrderinfo : tradeOrderinfos) {
//            GoodDeliverVO goodDeliverVO = new GoodDeliverVO();
//            Long goodsId = tradeOrderinfo.getGoodsId();
//            TGoods tGoods = tGoodsMapper.selectByPrimaryKey(goodsId);
//            BeanUtils.copyProperties(tGoods,goodDeliverVO);
//            // 加入商品品牌
//            BeanUtils.copyProperties(tradeOrderinfo, goodDeliverVO);
//            // 查询商品型号
//            Long brandId = tGoods.getBrandId();
//            for (TGoodsBrand tGoodsBrand1 : tGoodsBrands) {
//                if (brandId.equals(tGoodsBrand1.getBrandId())) {
//                    tGoodsBrand = tGoodsBrand1;
//                }
//            }
//            // 加入商品型号
//            BeanUtils.copyProperties(tGoodsBrand,goodDeliverVO);
//            goodDeliverVOS.add(goodDeliverVO);
//        }
//        // 将商品信息添加到销售出库单中
//        tradeDeliverOrderVO.setGoodDeliverVOs(goodDeliverVOS);
        // TODO 添加流程日志，客服备注信息

        return result;
    }

    /**
     * 分页展示待出库单
     * @param currentPage 当前数据
     * @param pageSize 页面显示数量
     * @return 待出库单
     */
    @Override
    public List<OrderVO> listDeliverOrder(int currentPage, int pageSize) {
        List<OrderVO> orderVOList = new ArrayList<>(pageSize);
        // 获取分页订单
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        tradeOrderExample.createCriteria().andOrderStateEqualTo(StateEnum.PAID.getState());
        PageHelper.startPage(currentPage,pageSize);
        List<TradeOrder> tradeOrders = tradeOrderMapper.selectByExample(tradeOrderExample);
        if(tradeOrders.isEmpty()){
            return Collections.emptyList();
        }
        // 根据订单id查询相关的快递单数据
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        OrderVO orderVO = new OrderVO();
        pageOrderVO(orderVOList, tradeOrders, tradeExpressinfoExample, orderVO, tradeExpressinfoMapper);
        return orderVOList;
    }

    static void pageOrderVO(List<OrderVO> orderVOList, List<TradeOrder> tradeOrders, TradeExpressinfoExample tradeExpressinfoExample, OrderVO orderVO, TradeExpressinfoMapper tradeExpressinfoMapper) {
        for (TradeOrder tradeOrder : tradeOrders) {
            Long orderId = tradeOrder.getOrderId();
            BeanUtils.copyProperties(tradeOrder, orderVO);
            // 将快递信息传递
            tradeExpressinfoExample.clear();
            tradeExpressinfoExample.createCriteria().andOrderIdEqualTo(orderId);
            List<TradeExpressinfo> tradeExpressinfos = tradeExpressinfoMapper.selectByExample(tradeExpressinfoExample);
            TradeExpressinfo tradeExpressinfo = tradeExpressinfos.get(0);
            BeanUtils.copyProperties(tradeExpressinfo, orderVO);
            orderVOList.add(orderVO);
        }
    }

    /**
     * 新增出库单方法
     * @param result 计数
     * @param date 当天日期
     * @param orderId 订单id
     * @return 新增数量
     */
    private int getResult(TradeOrder tradeOrder, int result, Date date, Long orderId) {
        TradeDelivery tradeDelivery = new TradeDelivery();
        tradeOrder.setOrderState(StateEnum.OUTBOUND.getState());
        int i = tradeOrderMapper.updateByPrimaryKey(tradeOrder);
        if(i == 1){
            // 设置出库单订单号、时间
            tradeDelivery.setOrderId(orderId);
            tradeDelivery.setCreateTime(date);
            tradeDelivery.setUpdateTime(date);
            // TODO 设置出库单处理人
            // 将销售出库单信息插入数据库
            result += tradeDeliveryMapper.insert(tradeDelivery);
        }
        return result;
    }


}
