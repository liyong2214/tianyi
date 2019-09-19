package com.tianyi.goods.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CommodityPromotionPropose {
    private Integer id;

    private Long proposerId;

    private Long commodityId;

    private BigDecimal goodsPurchasePrice;

    private String goodsWarehouseDistribute;

    private Date rushShoppingStartTime;

    private Date rushShoppingEndTime;

    private BigDecimal priceModificationAbsolute;

    private Float priceModificationRelative;

    private Integer targetAdjustPrice;

    private Integer approveStage;

    private Boolean approveResult;

    private Date proposeTime;

    private Integer proposeType;

    private String adjustReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProposerId() {
        return proposerId;
    }

    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public BigDecimal getGoodsPurchasePrice() {
        return goodsPurchasePrice;
    }

    public void setGoodsPurchasePrice(BigDecimal goodsPurchasePrice) {
        this.goodsPurchasePrice = goodsPurchasePrice;
    }

    public String getGoodsWarehouseDistribute() {
        return goodsWarehouseDistribute;
    }

    public void setGoodsWarehouseDistribute(String goodsWarehouseDistribute) {
        this.goodsWarehouseDistribute = goodsWarehouseDistribute == null ? null : goodsWarehouseDistribute.trim();
    }

    public Date getRushShoppingStartTime() {
        return rushShoppingStartTime;
    }

    public void setRushShoppingStartTime(Date rushShoppingStartTime) {
        this.rushShoppingStartTime = rushShoppingStartTime;
    }

    public Date getRushShoppingEndTime() {
        return rushShoppingEndTime;
    }

    public void setRushShoppingEndTime(Date rushShoppingEndTime) {
        this.rushShoppingEndTime = rushShoppingEndTime;
    }

    public BigDecimal getPriceModificationAbsolute() {
        return priceModificationAbsolute;
    }

    public void setPriceModificationAbsolute(BigDecimal priceModificationAbsolute) {
        this.priceModificationAbsolute = priceModificationAbsolute;
    }

    public Float getPriceModificationRelative() {
        return priceModificationRelative;
    }

    public void setPriceModificationRelative(Float priceModificationRelative) {
        this.priceModificationRelative = priceModificationRelative;
    }

    public Integer getTargetAdjustPrice() {
        return targetAdjustPrice;
    }

    public void setTargetAdjustPrice(Integer targetAdjustPrice) {
        this.targetAdjustPrice = targetAdjustPrice;
    }

    public Integer getApproveStage() {
        return approveStage;
    }

    public void setApproveStage(Integer approveStage) {
        this.approveStage = approveStage;
    }

    public Boolean getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Boolean approveResult) {
        this.approveResult = approveResult;
    }

    public Date getProposeTime() {
        return proposeTime;
    }

    public void setProposeTime(Date proposeTime) {
        this.proposeTime = proposeTime;
    }

    public Integer getProposeType() {
        return proposeType;
    }

    public void setProposeType(Integer proposeType) {
        this.proposeType = proposeType;
    }

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason == null ? null : adjustReason.trim();
    }
}