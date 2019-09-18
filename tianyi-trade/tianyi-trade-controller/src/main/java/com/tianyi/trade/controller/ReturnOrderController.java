package com.tianyi.trade.controller;

import com.tianyi.trade.model.VO.GoDownEntryVO;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeReturnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 销售退货管理
 * @author : Hens
 * @date : 2019/9/11 16:21
 */
@RestController
@RequestMapping(value = "/return")
public class ReturnOrderController {
    private final ITradeReturnService tradeReturnService;
    @Autowired
    public ReturnOrderController(ITradeReturnService tradeReturnService) {
        this.tradeReturnService = tradeReturnService;
    }

    /**
     * 销售退货单生成
     * @param id 指定id
     * @return goDownEntry 销售退货单
     */
    @GetMapping("/godown_entry/{id}")
    public ResponseEntity<GoDownEntryVO> getSaleReturnOrder(@PathVariable("id") Long id){
        GoDownEntryVO goDownEntryVO = tradeReturnService.getGoDownEntryVO(id);
        if(goDownEntryVO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(goDownEntryVO);
    }

    /**
     *  分页查看退货单
     * @param currentPage 当前
     * @param pageSize 每页数量
     * @return 退货单列表
     */
    @GetMapping("/orders")
    public ResponseEntity<List<OrderVO>> listOrderVO(int currentPage, int pageSize){
        List<OrderVO> orderVOList = tradeReturnService.listReturnOrder(currentPage, pageSize);
        return ResponseEntity.ok(orderVOList);
    }

    /**
     *  查看退货单
     * @param id 退货单序号
     * @return 退货单详情
     */
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderInfoVO> getOrderVO(@PathVariable Long id){
        System.out.println(id);
        OrderInfoVO orderInfoVO = tradeReturnService.getReturnOrderInfo(id);
        return ResponseEntity.ok(orderInfoVO);
    }
}
