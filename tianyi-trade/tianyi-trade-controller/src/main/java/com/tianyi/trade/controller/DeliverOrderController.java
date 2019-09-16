package com.tianyi.trade.controller;

import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeDeliverOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 销售出库单管理
 * @author : Hens
 * @date : 2019/9/11 16:18
 */
@RestController
@CrossOrigin
@Transactional(rollbackFor = Exception.class)
@RequestMapping(value = "/delivery")
public class DeliverOrderController {

    private final ITradeDeliverOrderService tradeDeliverOrderService;
    @Autowired
    public DeliverOrderController(ITradeDeliverOrderService tradeDeliverOrderService) {
        this.tradeDeliverOrderService = tradeDeliverOrderService;
    }

    /**
     * 生成销售出库单 传入为空则打印当前到上一个时间段的订单，有指则生成指定订单
     * @return 返回生成数量
     */
    @PostMapping("orders")
    public ResponseEntity<String> saveDeliverOrder(List<Long> orderIds){
        Integer integer = tradeDeliverOrderService.saveTradeDeliverOrder(orderIds);
        int size = orderIds.size();
        if(integer != size){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
        return ResponseEntity.ok("success");
    }

    /**
     * 分页展示出库单信息
     * @param currentPage 当前数据编号
     * @param pageSize 显示量
     * @return 分页信息
     */
    @GetMapping("orders")
    public ResponseEntity<List<OrderVO>> listDeliverOrder(int currentPage, int pageSize){
        List<OrderVO> orderVOList = tradeDeliverOrderService.listDeliverOrder(currentPage, pageSize);
        if(CollectionUtils.isEmpty(orderVOList)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(orderVOList);
    }

    // TODO 销售出库查询调用TradeOrderController getOrderInfo
    // 生成销售出库单


}
