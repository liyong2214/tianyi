package com.tianyi.trade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * trade_order
 * @author 
 */
public class TradeOrder implements Serializable {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单分类 B2C
     */
    private Integer typeId;

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
     * 订单状态 0审核通过 1已付款 2 已出库 3 已发货 4 已到货 5 已归档
     */
    private Integer orderState;

    /**
     * 总金额
     */
    private Long orderTotal;

    /**
     * 会员编号
     */
    private Long customerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Long getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Long orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TradeOrder other = (TradeOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
            && (this.getActionId() == null ? other.getActionId() == null : this.getActionId().equals(other.getActionId()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getOrderState() == null ? other.getOrderState() == null : this.getOrderState().equals(other.getOrderState()))
            && (this.getOrderTotal() == null ? other.getOrderTotal() == null : this.getOrderTotal().equals(other.getOrderTotal()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getActionId() == null) ? 0 : getActionId().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getOrderState() == null) ? 0 : getOrderState().hashCode());
        result = prime * result + ((getOrderTotal() == null) ? 0 : getOrderTotal().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", typeId=").append(typeId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", actionId=").append(actionId);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", orderState=").append(orderState);
        sb.append(", orderTotal=").append(orderTotal);
        sb.append(", customerId=").append(customerId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}