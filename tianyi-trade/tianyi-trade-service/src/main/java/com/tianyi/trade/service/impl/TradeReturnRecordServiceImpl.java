package com.tianyi.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.tianyi.trade.mapper.TradeExpressinfoMapper;
import com.tianyi.trade.mapper.TradeOrderMapper;
import com.tianyi.trade.mapper.TradeOrderinfoMapper;
import com.tianyi.trade.mapper.TradeReturnOrderMapper;
import com.tianyi.trade.model.*;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.TradeReturnOrderVO;
import com.tianyi.trade.model.VO.TradeReturnVO;
import com.tianyi.trade.service.ITradeReturnRecordService;
import com.tianyi.trade.utils.JedisUtil;
import com.tianyi.trade.utils.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * 退货单记录
 * @author : Hens
 * @date : 2019/9/13 22:51
 */
@Service
public class TradeReturnRecordServiceImpl implements ITradeReturnRecordService {
    @Autowired
    private TradeReturnOrderMapper tradeReturnOrderMapper;
    @Autowired
    private TradeOrderMapper tradeOrderMapper;
    @Autowired
    private TradeOrderinfoMapper tradeOrderinfoMapper;
    @Autowired
    private TradeExpressinfoMapper tradeExpressinfoMapper;

    /**
     * 分页查看退货单记录
     * @param currentPage 当前
     * @param pageSize 每页显示
     * @return 退货单列表
     */
    @Override
    public List<TradeReturnVO> listReturnVO(int currentPage, int pageSize) {
        List<TradeReturnVO> tradeReturnVOS = new ArrayList<>();
        // 计算开始值和结束值
        Long start = (long) ((currentPage - 1) * pageSize);
        Long end = (long) (currentPage * pageSize - 1);
        // 从 redis 查询 用 zset 和 hash做热点数据分页
        // zset key score value \key: returnid \score: time \value: id
        // hset key field value \key: return \field:id  \value: content
        String zkey = "tr:re:id";
        Set<String> zrange = JedisUtil.zrange(zkey, start, end);
        // 存入hash的key值
        String hkey = "tr:re";
        // 如果为空则从数据库查找
        if(CollectionUtils.isEmpty(zrange)){
            // map  key:id  value: time
            Map<String, Double> data = new HashMap<>(pageSize);
            // 数据库分页查询
            PageHelper.startPage(currentPage,pageSize);
            List<TradeReturnOrder> tradeReturnOrders = tradeReturnOrderMapper.selectByExample(null);
            for (TradeReturnOrder tradeReturnOrder : tradeReturnOrders) {
                TradeReturnVO tradeReturnVO = new TradeReturnVO();
                BeanUtils.copyProperties(tradeReturnOrder, tradeReturnVO);
                tradeReturnVOS.add(tradeReturnVO);
                // 存入map
                data.put(tradeReturnVO.getReturnId().toString(),Double.longBitsToDouble(tradeReturnVO.getCreateTime().getTime()));
                // 往 redis 存hash
                String returnVO = JsonUtils.objectToJson(tradeReturnVO);

                JedisUtil.hset(hkey,tradeReturnOrder.getReturnId().toString(),returnVO,600);
            }
            // 往 reids 存Zset
            JedisUtil.zadd(zkey,data,600);
            return tradeReturnVOS;
        }

        // 从redis 取数据
        String[] strings = new String[]{};
        List<String> hmget = JedisUtil.hmget(hkey, zrange.toArray(strings));
        if(!CollectionUtils.isEmpty(hmget)){
            for (String orderStr: hmget) {
                TradeReturnVO tradeReturnVO = JsonUtils.jsonToObject(orderStr, TradeReturnVO.class);
                tradeReturnVOS.add(tradeReturnVO);
            }
        }
        return tradeReturnVOS;
    }

    /**
     * 获取退货单详情
     * @param id 退货单序号
     * @return
     */
    @Override
    public TradeReturnOrderVO getReturnOrder(Long id) {
        TradeReturnOrderVO tradeReturnOrderVO = new TradeReturnOrderVO();
        TradeReturnOrder tradeReturnOrder = tradeReturnOrderMapper.selectByPrimaryKey(id);
        if(tradeReturnOrder == null){
            return null;
        }
        Long orderId = tradeReturnOrder.getOrderId();
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        // 根据orderId 查询order信息
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        tradeOrderExample.createCriteria().andOrderIdEqualTo(orderId);
        TradeOrder tradeOrder = tradeOrderMapper.selectByExample(tradeOrderExample).get(0);
        if(tradeOrder == null){
            return null;
        }
        BeanUtils.copyProperties(tradeOrder,orderInfoVO);
        // 查询orderinfo商品信息
        TradeOrderinfoExample tradeOrderinfoExample = new TradeOrderinfoExample();
        tradeOrderinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeOrderinfo> tradeOrderinfos = tradeOrderinfoMapper.selectByExample(tradeOrderinfoExample);
        orderInfoVO.setTradeOrderinfos(tradeOrderinfos);
        // 查询快递信息
        TradeExpressinfoExample tradeExpressinfoExample = new TradeExpressinfoExample();
        tradeExpressinfoExample.createCriteria().andOrderIdEqualTo(orderId);
        List<TradeExpressinfo> tradeExpressinfos = tradeExpressinfoMapper.selectByExample(tradeExpressinfoExample);
        BeanUtils.copyProperties(tradeExpressinfos.get(0),orderInfoVO);
        // 设置订单信息
        BeanUtils.copyProperties(orderInfoVO,tradeReturnOrderVO);
        // 设置拒收信息
        BeanUtils.copyProperties(tradeReturnOrder,tradeReturnOrderVO);
        return tradeReturnOrderVO;
    }
}
