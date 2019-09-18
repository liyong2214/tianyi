package com.tianyi.trade.controller;

import com.tianyi.trade.constant.TradeEnum;
import com.tianyi.trade.exception.OrderException;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.model.VO.TradeOrderVO;
import com.tianyi.trade.service.ITradeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 销售订单查询
 * @author : Hens
 * @date : 2019/9/8 13:49
 */
@RestController
@CrossOrigin
@Transactional(rollbackFor = Exception.class)
@RequestMapping(value = "/trade")
public class TradeOrderController {

    private final ITradeOrderService tradeOrderService;
    @Autowired
    public TradeOrderController(ITradeOrderService tradeOrderService) {
        this.tradeOrderService = tradeOrderService;
    }
    /**
     * 接收天翼传入订单
     * @param tradeOrderVO 传入天翼订单
     * @return 返回状态
     */
    @PostMapping("orders")
    public ResponseEntity<String> saveOrder(@RequestBody TradeOrderVO tradeOrderVO) throws OrderException {
        System.out.println(tradeOrderVO);
        Integer integer = tradeOrderService.saveOrder(tradeOrderVO);
        // 获取购买商品种类数量
        int size = tradeOrderVO.getTradeOrderinfos().size();
        // 预期成功插入结果 2为订单表和快递单表
        int insertNum = size + 2;
        if(integer != insertNum){
            throw new OrderException(TradeEnum.ORDER_INSERT_FAILURE);
        }
        return ResponseEntity.ok("success");
    }

    /**
     * 分页查询订单
     * @param currentPage 当前数据量
     * @param pageSize 页面显示数量
     * @return 返回订单数组
     */
    @GetMapping("orders")
    public ResponseEntity<List<OrderVO>> listOrder(int currentPage, int pageSize){
        List<OrderVO> orderVOList = tradeOrderService.listOrderVO(currentPage, pageSize);
        return ResponseEntity.ok(orderVOList);
    }

    /**
     * 获取指定id订单信息
     * @param id 订单序号
     * @return 订单详细信息
     */
    @GetMapping("orders/{id}")
    public ResponseEntity<OrderInfoVO> getOrderInfo(@PathVariable Long id){
        OrderInfoVO orderInfo = tradeOrderService.getOrderInfo(id);
        return ResponseEntity.ok(orderInfo);
    }
}


