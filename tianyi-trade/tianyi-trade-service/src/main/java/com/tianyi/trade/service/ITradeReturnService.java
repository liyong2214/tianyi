package com.tianyi.trade.service;

import com.tianyi.trade.model.VO.GoDownEntryVO;
import com.tianyi.trade.model.VO.OrderInfoVO;
import com.tianyi.trade.model.VO.OrderVO;
import java.util.List;
/**
 * @author : Hens
 * @date : 2019/9/13 20:58
 */
public interface ITradeReturnService {
    /**
     * 分页查看销售退货单
     * @param currentPage 当前数据
     * @param pageSize 每页显示数量
     * @return 返回分页数据
     */
    public List<OrderVO> listReturnOrder(int currentPage, int pageSize);

    /**
     * 查看指定id 退货单信息
     * @param id 退货单序号
     * @return 退货单信息
     */
    public OrderInfoVO getReturnOrderInfo(Long id);

    /**
     * 生成退货单
     * @param id 退货单序号
     * @return
     */
    public GoDownEntryVO getGoDownEntryVO(Long id);
}
