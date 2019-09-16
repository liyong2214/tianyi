package com.tianyi.trade.model.VO;

import com.tianyi.trade.model.TradeOrderinfo;

import java.util.Date;
import java.util.List;
/**
 * 天翼传入订单
 * @author : Hens
 * @date : 2019/9/8 16:01
 */
public class TradeOrderVO extends OrderInfoVO{
    /**
     * 订单分类 B2C
     */
    private Integer typeId;

    /**
     * 快递单号
     */
    private Long expressId;

    public TradeOrderVO() {
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    public TradeOrderVO(Long orderId, Integer resourceId, Date createTime, Integer actionId, Integer tradeType, List<TradeOrderinfo> tradeOrderinfos, String username, Integer expressType, Long expressCost, String expressAddress, String receiver, String postcode, String receiverAddress, String receiverEmail, String receiverContact, String receiverMobile, Integer payType, Date receiveTime, String note, String remitter, Integer orderState, Integer typeId, Long expressId) {
        super(orderId, resourceId, createTime, actionId, tradeType, tradeOrderinfos, username, expressType, expressCost, expressAddress, receiver, postcode, receiverAddress, receiverEmail, receiverContact, receiverMobile, payType, receiveTime, note, remitter, orderState);
        this.typeId = typeId;
        this.expressId = expressId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
