package com.tianyi.trade.controller;

import com.tianyi.trade.model.VO.DeliveryOrderInfoVO;
import com.tianyi.trade.model.VO.DeliveryVO;
import com.tianyi.trade.service.ITradeDeliverRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 销售出库单记录
 * @author : Hens
 * @date : 2019/9/12 22:05
 */
@RestController
@RequestMapping(value = "/deliveryrecord")
@CrossOrigin
public class DeliveryRecordController {

    private final ITradeDeliverRecordService tradeDeliverRecordService;
    @Autowired
    public DeliveryRecordController(ITradeDeliverRecordService tradeDeliverRecordService) {
        this.tradeDeliverRecordService = tradeDeliverRecordService;
    }

    /**
     * 分页查看销售出库单
     * @param currentPage 当前数据编号
     * @param pageSize 每页显示数量
     * @return 分页数据
     */
    @GetMapping("/records")
    public ResponseEntity<List<DeliveryVO>> listDeliveryRecord(int currentPage, int pageSize){
        List<DeliveryVO> deliveryVOS = tradeDeliverRecordService.listDelivery(currentPage, pageSize);
        if(CollectionUtils.isEmpty(deliveryVOS)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(deliveryVOS);
    }

    /**
     * 根据指定id查看销售出库单
     * @param id 销售出库单编号
     * @return 详细数据
     */
    @GetMapping("/records/{id}")
    public ResponseEntity<DeliveryOrderInfoVO> getDeliveryRecode(@PathVariable Long id){
        DeliveryOrderInfoVO delivery = tradeDeliverRecordService.getDelivery(id);
        return ResponseEntity.ok(delivery);
    }


}
