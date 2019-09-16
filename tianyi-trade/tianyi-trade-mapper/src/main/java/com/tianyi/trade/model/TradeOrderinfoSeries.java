package com.tianyi.trade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * trade_orderinfo_series
 * @author 
 */
public class TradeOrderinfoSeries implements Serializable {
    /**
     * 商品机型串号与商品表id
     */
    private Long id;

    /**
     * 商品详情id
     */
    private Long orderinfoId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品机型串号
     */
    private String goodsSeries;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderinfoId() {
        return orderinfoId;
    }

    public void setOrderinfoId(Long orderinfoId) {
        this.orderinfoId = orderinfoId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSeries() {
        return goodsSeries;
    }

    public void setGoodsSeries(String goodsSeries) {
        this.goodsSeries = goodsSeries;
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
        TradeOrderinfoSeries other = (TradeOrderinfoSeries) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderinfoId() == null ? other.getOrderinfoId() == null : this.getOrderinfoId().equals(other.getOrderinfoId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsSeries() == null ? other.getGoodsSeries() == null : this.getGoodsSeries().equals(other.getGoodsSeries()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderinfoId() == null) ? 0 : getOrderinfoId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsSeries() == null) ? 0 : getGoodsSeries().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", orderinfoId=").append(orderinfoId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsSeries=").append(goodsSeries);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}