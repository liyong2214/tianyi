package com.tianyi.trade.model.VO;

import com.tianyi.trade.model.TradeOrderinfo;

import java.util.Date;
import java.util.List;

/**
 * 销售出库单详情
 * @author : Hens
 * @date : 2019/9/12 17:42
 */
public class DeliveryOrderInfoVO extends OrderInfoVO {
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;

    public DeliveryOrderInfoVO() {
    }

    public DeliveryOrderInfoVO(Long orderId, Integer resourceId, Date createTime, Integer actionId, Integer tradeType, List<TradeOrderinfo> tradeOrderinfos, String username, Integer expressType, Long expressCost, String expressAddress, String receiver, String postcode, String receiverAddress, String receiverEmail, String receiverContact, String receiverMobile, Integer payType, Date receiveTime, String note, String remitter, Integer orderState, String createUser, Date createTime1) {
        super(orderId, resourceId, createTime, actionId, tradeType, tradeOrderinfos, username, expressType, expressCost, expressAddress, receiver, postcode, receiverAddress, receiverEmail, receiverContact, receiverMobile, payType, receiveTime, note, remitter, orderState);
        this.createUser = createUser;
        this.createTime = createTime1;
    }

    @Override
    public String toString() {
        return "DeliveryOrderInfoVO{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                "} " + super.toString();
    }
}
