package com.tianyi.goods.entity;

import java.util.Date;

public class GoodsPricePropose {
    private Integer id;

    private Long proposerId;

    private Long commodityId;

    private Integer targetAdjustPrice;

    private Float priceModification;

    private Date startTime;

    private Date endTime;

    private Integer approveStage;

    private Boolean approveResult;

    private Date proposeTime;

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

    public Integer getTargetAdjustPrice() {
        return targetAdjustPrice;
    }

    public void setTargetAdjustPrice(Integer targetAdjustPrice) {
        this.targetAdjustPrice = targetAdjustPrice;
    }

    public Float getPriceModification() {
        return priceModification;
    }

    public void setPriceModification(Float priceModification) {
        this.priceModification = priceModification;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason == null ? null : adjustReason.trim();
    }
}