package com.tianyi.trade.model.VO;

import com.tianyi.trade.model.TradeOrderinfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 用于展示销售退货信息
 * @author : Hens
 * @date : 2019/9/13 22:48
 */
public class TradeReturnOrderVO extends OrderInfoVO{
    /**
     * 拒收原因
     */
    private String rejection;

    /**
     * 拒收时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date rejectTime;

    public TradeReturnOrderVO() {
    }

    public TradeReturnOrderVO(Long orderId, Integer resourceId, Date createTime, Integer actionId, Integer tradeType, List<TradeOrderinfo> tradeOrderinfos, String username, Integer expressType, Long expressCost, String expressAddress, String receiver, String postcode, String receiverAddress, String receiverEmail, String receiverContact, String receiverMobile, Integer payType, Date receiveTime, String note, String remitter, Integer orderState, String rejection, Date rejectTime) {
        super(orderId, resourceId, createTime, actionId, tradeType, tradeOrderinfos, username, expressType, expressCost, expressAddress, receiver, postcode, receiverAddress, receiverEmail, receiverContact, receiverMobile, payType, receiveTime, note, remitter, orderState);
        this.rejection = rejection;
        this.rejectTime = rejectTime;
    }

    @Override
    public String toString() {
        return "TradeReturnOrderVO{" +
                "rejection='" + rejection + '\'' +
                ", rejectTime=" + rejectTime +
                '}';
    }

    public String getRejection() {
        return rejection;
    }

    public void setRejection(String rejection) {
        this.rejection = rejection;
    }

    public Date getRejectTime() {
        return rejectTime;
    }

    public void setRejectTime(Date rejectTime) {
        this.rejectTime = rejectTime;
    }
}
