package com.tianyi.trade.controller;

import com.tianyi.trade.model.VO.TradeReturnOrderVO;
import com.tianyi.trade.model.VO.TradeReturnVO;
import com.tianyi.trade.service.ITradeReturnRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 销售退货单记录
 * @author : Hens
 * @date : 2019/9/13 23:08
 */
@RestController
@CrossOrigin
@Transactional(rollbackFor = Exception.class)
@RequestMapping(value = "/return_record")
public class ReturnOrderRecordController {
    @Autowired
    private ITradeReturnRecordService returnRecordService;

    /**
     * 分页查看
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/orders")
    public ResponseEntity<List<TradeReturnVO>> listReturnRecord(int currentPage, int pageSize){
        List<TradeReturnVO> tradeReturnVOS = returnRecordService.listReturnVO(currentPage, pageSize);
        return ResponseEntity.ok(tradeReturnVOS);
    }

    /**
     * 查看指定销售退货单记录
     * @param returnId
     * @return
     */
    @GetMapping("/orders/{returnId}")
    public ResponseEntity<TradeReturnOrderVO> getRecord(@Param("returnId") Long returnId){
        TradeReturnOrderVO returnOrder = returnRecordService.getReturnOrder(returnId);
        return ResponseEntity.ok(returnOrder);
    }
}
