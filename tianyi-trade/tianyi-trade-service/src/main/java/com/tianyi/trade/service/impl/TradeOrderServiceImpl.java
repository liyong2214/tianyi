package com.tianyi.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.tianyi.trade.constant.StateEnum;
import com.tianyi.trade.mapper.TradeCustomerMapper;
import com.tianyi.trade.mapper.TradeExpressinfoMapper;
import com.tianyi.trade.mapper.TradeOrderMapper;
import com.tianyi.trade.mapper.TradeOrderinfoMapper;
import com.tianyi.trade.model.*;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.model.VO.TradeOrderVO;
import com.tianyi.trade.service.ITradeOrderService;
import com.tianyi.trade.utils.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 销售订单查询功能
 * @author : Hens
 * @date : 2019/9/8 13:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TradeOrderServiceImpl implements ITradeOrderService {
    /**
     * 开启日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeOrderServiceImpl.class);

    private final TradeOrderMapper tradeOrderMapper;
    private final TradeExpressinfoMapper tradeExpressinfoMapper;
    private final TradeOrderinfoMapper tradeOrderinfoMapper;
    private final TradeCustomerMapper tradeCustomerMapper;

    @Autowired
    public TradeOrderServiceImpl(TradeOrderMapper tradeOrderMapper, TradeExpressinfoMapper tradeExpressinfoMapper, TradeOrderinfoMapper tradeOrderinfoMapper, TradeCustomerMapper tradeCustomerMapper) {
        this.tradeOrderMapper = tradeOrderMapper;
        this.tradeExpressinfoMapper = tradeExpressinfoMapper;
        this.tradeOrderinfoMapper = tradeOrderinfoMapper;
        this.tradeCustomerMapper = tradeCustomerMapper;
    }

    /**
     * 添加天翼订单信息
     * @param tradeOrderVO 传入的信息
     * @return 返回成功加入的数量
     */
    @Override
    public Integer saveOrder(TradeOrderVO tradeOrderVO) {
        // 获取订单状态是否为已审核，付款
        Integer orderState = tradeOrderVO.getOrderState();
        if(orderState > StateEnum.PAID.getState()){
            return 0;
        }
        // 新建对应数据库实体类用于接收存放
        TradeOrder tradeOrder = new TradeOrder();
        TradeExpressinfo tradeExpressinfo = new TradeExpressinfo();
        // bean属性赋值给订单表和快递单实体类
        BeanUtils.copyProperties(tradeOrderVO,tradeOrder);
        BeanUtils.copyProperties(tradeOrderVO,tradeExpressinfo);
        // 定义result用于统计存入数量是否一致，否则返回
        int result = 0;
        // 获取订单id 并赋值和存入数据库
        Long orderId = tradeOrderVO.getOrderId();
        List<TradeOrderinfo> tradeOrderinfos = tradeOrderVO.getTradeOrderinfos();
        for (TradeOrderinfo tradeOrderinfo : tradeOrderinfos) {
            tradeOrderinfo.setOrderId(orderId);
            result += tradeOrderinfoMapper.insert(tradeOrderinfo);
        }
        // 查询会员编号
        String username = tradeOrder.getUsername();
        TradeCustomerExample tradeCustomerExample = new TradeCustomerExample();
        tradeCustomerExample.createCriteria().andUsernameEqualTo(username);
        List<TradeCustomer> tradeCustomers = tradeCustomerMapper.selectByExample(tradeCustomerExample);
        tradeExpressinfo.setUsername(username);
        // 信息添加到数据库
        tradeOrder.setOrderId(orderId);
        result += tradeOrderMapper.insert(tradeOrder);
        result += tradeExpressinfoMapper.insert(tradeExpressinfo);
        LOGGER.info("新增共 [{}] 数据条",result);
        return result;
    }

    /**
     * 分页展示数据
     * @param currentPage 当前数据
     * @param pageSize 每页显示数据量
     * @return 分页订单信息
     */
    @Override
    public List<OrderVO> listOrderVO(Integer currentPage, Integer pageSize) {
        List<OrderVO> orderVOList = new ArrayList<>();
        // 从redis 查询
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("tr:o:");
//        String key = stringBuffer.append(currentPage).toString();
//        long start = currentPage;
//        long end = currentPage * pageSize;
//        List<String> orderStr = JedisUtil.lrange(key, start, end);

            // 获取分页订单
            PageHelper.startPage(currentPage,pageSize);
            List<TradeOrder> tradeOrders = tradeOrderMapper.selectByExample(null);
            if(tradeOrders.isEmpty()){
                return Collections.emptyList();
            }
            // 存入redis

            // 根据订单id查询相关的快递单数据
            TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
            OrderVO orderVO = new OrderVO();
            TradeDeliverOrderServiceImpl.pageOrderVO(orderVOList, tradeOrders, tradeExpressinfoExample, orderVO, tradeExpressinfoMapper);
            // 存入redis
        return orderVOList;
    }

    /**
     * 查询订单详情信息
     * @param id 订单编号
     * @return 返回订单详情
     */
    @Override
    public OrderInfoVO getOrderInfo(Long id) {
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
     * 查询要导出为excel的订单信息
     * @param ids 传入的订单序号
     * @return 返回订单信息
     */
    @Override
    public List<OrderVO> excelOrderVO(List<Long> ids) {
        List<OrderVO> orderVOList = new ArrayList<>();
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        OrderVO orderVO = new OrderVO();
        for (Long id : ids) {
            TradeOrder tradeOrder = tradeOrderMapper.selectByPrimaryKey(id);
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
        return orderVOList;
    }

}
