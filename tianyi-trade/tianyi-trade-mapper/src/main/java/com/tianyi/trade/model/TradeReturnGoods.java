package com.tianyi.trade.model;

import java.io.Serializable;

/**
 * trade_return_goods
 * @author 
 */
public class TradeReturnGoods extends TradeReturnGoodsKey implements Serializable {
    /**
     * 出库数量
     */
    private Integer goodsAmount;

    /**
     * 机型
     */
    private String productModel;

    /**
     * 机型串号
     */
    private String goodsSeries;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
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
        TradeReturnGoods other = (TradeReturnGoods) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsAmount() == null ? other.getGoodsAmount() == null : this.getGoodsAmount().equals(other.getGoodsAmount()))
            && (this.getProductModel() == null ? other.getProductModel() == null : this.getProductModel().equals(other.getProductModel()))
            && (this.getGoodsSeries() == null ? other.getGoodsSeries() == null : this.getGoodsSeries().equals(other.getGoodsSeries()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsAmount() == null) ? 0 : getGoodsAmount().hashCode());
        result = prime * result + ((getProductModel() == null) ? 0 : getProductModel().hashCode());
        result = prime * result + ((getGoodsSeries() == null) ? 0 : getGoodsSeries().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", productModel=").append(productModel);
        sb.append(", goodsSeries=").append(goodsSeries);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}