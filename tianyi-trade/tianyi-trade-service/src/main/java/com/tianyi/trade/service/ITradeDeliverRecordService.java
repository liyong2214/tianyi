package com.tianyi.trade.service;

import com.tianyi.trade.model.VO.DeliveryOrderInfoVO;
import com.tianyi.trade.model.VO.DeliveryVO;

import java.util.List;
/**
 * 销售出库单记录
 * @author : Hens
 * @date : 2019/9/12 17:51
 */
public interface ITradeDeliverRecordService {

    /**
     * 分页查看销售出库记录
     * @param currentPage 当前数据
     * @param pageSize 当前页显示数据量
     * @return 返回分页信息
     */
    public List<DeliveryVO> listDelivery(int currentPage,int pageSize);

    /**
     * 查看指定销售出库记录
     * @param id 销售出库单编号
     * @return 销售出库单记录
     */
    public DeliveryOrderInfoVO getDelivery(Long id);
}
