package com.tianyi.trade.model.VO;

import java.util.Date;

/**
 * 分页展示销售出库记录
 * @author : Hens
 * @date : 2019/9/12 19:16
 */
public class DeliveryVO extends OrderVO {
    /**
     * 创建时间
     */
    private Date createTime;

    public DeliveryVO() {
    }
    public DeliveryVO(Long id, Long orderId, Integer resourceId, Integer actionId, Integer tradeType, Integer payType, Integer expressType, Integer orderState, Date createTime) {
        super(id, orderId, resourceId, actionId, tradeType, payType, expressType, orderState);
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeliveryVO{" +
                "createTime=" + createTime +
                "} " + super.toString();
    }
}
