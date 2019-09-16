package com.tianyi.trade.service;

import com.tianyi.trade.model.VO.TradeReturnOrderVO;
import com.tianyi.trade.model.VO.TradeReturnVO;
import java.util.List;
/**
 * 销售退货单记录
 * @author : Hens
 * @date : 2019/9/13 22:43
 */
public interface ITradeReturnRecordService {
    /**
     * 分页查看销售退货单记录
     * @param currentPage 当前
     * @param pageSize 每页显示
     * @return 返回列表
     */
    public List<TradeReturnVO> listReturnVO(int currentPage, int pageSize);

    /**
     * 查看销售退货单信息
     * @param id 退货单序号
     * @return 销售退货单信息
     */
    public TradeReturnOrderVO getReturnOrder(Long id);
}
