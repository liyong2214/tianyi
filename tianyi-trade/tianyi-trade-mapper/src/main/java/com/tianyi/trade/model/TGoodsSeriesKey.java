package com.tianyi.trade.model;

import java.io.Serializable;

/**
 * t_goods_series
 * @author 
 */
public class TGoodsSeriesKey implements Serializable {
    /**
     * 商品编号
     */
    private Long goodsId;

    /**
     * 机型串号
     */
    private String goodsSeries;

    private static final long serialVersionUID = 1L;

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
        TGoodsSeriesKey other = (TGoodsSeriesKey) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsSeries() == null ? other.getGoodsSeries() == null : this.getGoodsSeries().equals(other.getGoodsSeries()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsSeries() == null) ? 0 : getGoodsSeries().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsSeries=").append(goodsSeries);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}