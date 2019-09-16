package com.tianyi.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.tianyi.trade.constant.StateEnum;
import com.tianyi.trade.mapper.*;
import com.tianyi.trade.model.*;
import com.tianyi.trade.model.VO.GoDownEntryVO;
import com.tianyi.trade.model.VO.GoodReturnVO;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeReturnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 退货单管理
 * @author : Hens
 * @date : 2019/9/13 21:01
 */
@Service
public class TradeReturnServiceImpl implements ITradeReturnService {
    @Autowired
    private TradeOrderMapper tradeOrderMapper;
    @Autowired
    private TradeExpressinfoMapper tradeExpressinfoMapper;
    @Autowired
    private TradeOrderinfoMapper tradeOrderinfoMapper;
    @Autowired
    private TradeOrderinfoSeriesMapper tradeOrderinfoSeriesMapper;
    @Autowired
    private TradeReturnOrderMapper tradeReturnOrderMapper;
    @Autowired
    private TradeReturnGoodsMapper tradeReturnGoodsMapper;

    /**
     * 查询订单状态为拒收的订单
     * @param currentPage 当前数据
     * @param pageSize 每页显示数量
     * @return 拒收订单
     */
    @Override
    public List<OrderVO> listReturnOrder(int currentPage, int pageSize) {
        List<OrderVO> orderVOList = new ArrayList<>();
        // 获取分页订单
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        tradeOrderExample.createCriteria().andOrderStateEqualTo(StateEnum.REJECTED.getState());
        PageHelper.startPage(currentPage,pageSize);
        List<TradeOrder> tradeOrders = tradeOrderMapper.selectByExample(tradeOrderExample);
        if(tradeOrders.isEmpty()){
            return Collections.emptyList();
        }
        // 根据订单id查询相关的快递单数据
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        OrderVO orderVO = new OrderVO();
        TradeDeliverOrderServiceImpl.pageOrderVO(orderVOList, tradeOrders, tradeExpressinfoExample, orderVO, tradeExpressinfoMapper);
        return orderVOList;
    }

    /**
     * 查看退货单详情
     * @param id 退货单序号
     * @return
     */
    @Override
    public OrderInfoVO getReturnOrderInfo(Long id) {
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        // 根据id 查询order信息
        TradeOrder tradeOrder = tradeOrderMapper.selectByPrimaryKey(id);
        if(tradeOrder == null){
            return null;
        }
        BeanUtils.copyProperties(tradeOrder,orderInfoVO);
        // 查询orderinfo商品信息
        Long orderId = tradeOrder.getOrderId();
        TradeOrderinfoExample tradeOrderinfoExample = new TradeOrderinfoExample();
        tradeOrderinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeOrderinfo> tradeOrderinfos = tradeOrderinfoMapper.selectByExample(tradeOrderinfoExample);
        orderInfoVO.setTradeOrderinfos(tradeOrderinfos);
        // 查询快递信息
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        tradeExpressinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeExpressinfo> tradeExpressinfos = tradeExpressinfoMapper.selectByExample(tradeExpressinfoExample);
        BeanUtils.copyProperties(tradeExpressinfos.get(0),orderInfoVO);
        return orderInfoVO;
    }

    /**
     * 生成退货单
     * @param id 退货单序号
     * @return 退货单详情
     */
    @Override
    public GoDownEntryVO getGoDownEntryVO(Long id) {
        GoDownEntryVO goDownEntryVO = new GoDownEntryVO();
        // 修改订单状态
        // 根据id 查询order信息 销售订单id
        TradeOrder tradeOrder = tradeOrderMapper.selectByPrimaryKey(id);
        if(tradeOrder == null){
            return null;
        }
        tradeOrder.setIsGodown(true);
        // 赋值返回信息
        BeanUtils.copyProperties(tradeOrder,goDownEntryVO);
        // TODO 设置申请人 申请人联系电话 申请人联系邮箱 申请时间 当前系统操作人员
        // 查询商品
        Long orderId = tradeOrder.getOrderId();
        TradeOrderinfoExample tradeOrderinfoExample = new TradeOrderinfoExample();
        tradeOrderinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeOrderinfo> tradeOrderinfos = tradeOrderinfoMapper.selectByExample(tradeOrderinfoExample);
        // 获取退货商品
        List<GoodReturnVO> goodReturnVOS = new ArrayList<>();
        // 查询商品机型串号 供货商
        for (TradeOrderinfo tradeOrderinfo : tradeOrderinfos) {
            GoodReturnVO goodReturnVO = new GoodReturnVO();
            BeanUtils.copyProperties(tradeOrderinfo, goodReturnVO);
            Long orderinfoId = tradeOrderinfo.getOrderinfoId();
            System.out.println(orderinfoId);
            TradeOrderinfoSeriesExample tradeOrderinfoSeriesExample = new TradeOrderinfoSeriesExample();
            tradeOrderinfoSeriesExample.createCriteria().andOrderinfoIdEqualTo(orderinfoId);
            List<TradeOrderinfoSeries> tradeOrderinfoSeries = tradeOrderinfoSeriesMapper.selectByExample(tradeOrderinfoSeriesExample);
            String goodsSeries = tradeOrderinfoSeries.get(0).getGoodsSeries();
            goodReturnVO.setGoodsSeries(goodsSeries);
            goodReturnVOS.add(goodReturnVO);
        }
        goDownEntryVO.setGoodReturnVOS(goodReturnVOS);
        // 存入退货单表
        TradeReturnOrder tradeReturnOrder = new TradeReturnOrder();
        BeanUtils.copyProperties(goDownEntryVO,tradeReturnOrder);
        tradeReturnOrder.setApplicant("li");
        tradeReturnOrder.setApplicantContact("413143433");
        tradeReturnOrder.setApplicantEmail("d4as31daww43d@163.com");
        tradeReturnOrder.setApplyTime(new Date());
        tradeReturnOrder.setName("lai");
        tradeReturnOrder.setExpressId(26315431L);
        tradeReturnOrder.setReceiverAddress("郑州");
        tradeReturnOrder.setRejection("难看");
        tradeReturnOrder.setRejectTime(new Date());
        tradeReturnOrder.setCreateTime(new Date());
        tradeReturnOrder.setUpdateTime(new Date());

        int insert = tradeReturnOrderMapper.insert(tradeReturnOrder);
        // 存入退货商品表
        for (int i = 0; i < tradeOrderinfos.size(); i++) {
            TradeReturnGoods tradeReturnGood = new TradeReturnGoods();
            BeanUtils.copyProperties(tradeOrderinfos.get(i),tradeReturnGood);
            System.out.println(tradeReturnGood);
            tradeReturnGood.setOrderId(orderId);
            tradeReturnGood.setGoodsId(tradeOrderinfos.get(i).getGoodsId());
            tradeReturnGoodsMapper.insert(tradeReturnGood);
        }
        return goDownEntryVO;
    }
}
