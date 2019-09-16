package com.tianyi.trade.model.VO;

/**
 * 用于分页展示
 * @author : Hens
 * @date : 2019/9/11 20:21
 */
public class OrderVO {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单类型 0电话订单 1网络订单2其他
     */
    private Integer resourceId;

    /**
     * 订单动作 0订购 1 换购 2 支付
     */
    private Integer actionId;
    /**
     * 业务类型
     */
    private Integer tradeType;
    /**
     * 支付方式(0货到付款、1款到发货)
     */
    private Integer payType;
    /**
     * 配送方式 ( 0 EMS\1 other)
     */
    private Integer expressType;
    /**
     * 订单状态 0审核通过 1已付款 2 已出库 3 已发货 4 已到货 5 已归档
     */
    private Integer orderState;

    public OrderVO() {
    }

    public OrderVO(Long id, Long orderId, Integer resourceId, Integer actionId, Integer tradeType, Integer payType, Integer expressType, Integer orderState) {
        this.id = id;
        this.orderId = orderId;
        this.resourceId = resourceId;
        this.actionId = actionId;
        this.tradeType = tradeType;
        this.payType = payType;
        this.expressType = expressType;
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", resourceId=" + resourceId +
                ", actionId=" + actionId +
                ", tradeType=" + tradeType +
                ", payType=" + payType +
                ", expressType=" + expressType +
                ", orderState=" + orderState +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}
