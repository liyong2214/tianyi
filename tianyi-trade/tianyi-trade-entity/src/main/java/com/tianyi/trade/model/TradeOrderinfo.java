package com.tianyi.trade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * trade_orderinfo
 * @author 
 */
public class TradeOrderinfo implements Serializable {
    /**
     * 订单详情编号id
     */
    private Long orderinfoId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 购买商品id
     */
    private Long goodId;

    /**
     * 购买商品数量
     */
    private Integer goodAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getOrderinfoId() {
        return orderinfoId;
    }

    public void setOrderinfoId(Long orderinfoId) {
        this.orderinfoId = orderinfoId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodAmount() {
        return goodAmount;
    }

    public void setGoodAmount(Integer goodAmount) {
        this.goodAmount = goodAmount;
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
        TradeOrderinfo other = (TradeOrderinfo) that;
        return (this.getOrderinfoId() == null ? other.getOrderinfoId() == null : this.getOrderinfoId().equals(other.getOrderinfoId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGoodId() == null ? other.getGoodId() == null : this.getGoodId().equals(other.getGoodId()))
            && (this.getGoodAmount() == null ? other.getGoodAmount() == null : this.getGoodAmount().equals(other.getGoodAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderinfoId() == null) ? 0 : getOrderinfoId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGoodId() == null) ? 0 : getGoodId().hashCode());
        result = prime * result + ((getGoodAmount() == null) ? 0 : getGoodAmount().hashCode());
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
        sb.append(", orderinfoId=").append(orderinfoId);
        sb.append(", orderId=").append(orderId);
        sb.append(", goodId=").append(goodId);
        sb.append(", goodAmount=").append(goodAmount);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}