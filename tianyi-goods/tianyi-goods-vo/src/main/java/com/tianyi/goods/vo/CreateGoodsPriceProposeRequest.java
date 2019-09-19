package com.tianyi.goods.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tianyi.goods.constant.GoodsPriceProposeErrorCode;
import com.tianyi.goods.entity.CommodityExample;
import com.tianyi.goods.entity.GoodsPricePropose;
import com.tianyi.goods.mapper.CommodityMapper;

import java.util.Date;

public class CreateGoodsPriceProposeRequest {
    private Integer id;

    private Long proposerId;

    private Long commodityId;

    private Integer targetAdjustPrice;

    private Float priceModification;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason == null ? null : adjustReason.trim();
    }

    public Date getProposeTime() {
        return proposeTime;
    }

    public void setProposeTime(Date proposeTime) {
        this.proposeTime = proposeTime;
    }

    /**
     * <h2>验证数据的有效性</h2>
     *
     * @param commodityMapper
     * @return {@link GoodsPriceProposeErrorCode}
     */
    public GoodsPriceProposeErrorCode validate(CommodityMapper commodityMapper) {
        if (null == this.proposerId) {
            return GoodsPriceProposeErrorCode.EMPTY_PROPOSER;
        }

        if (null == this.commodityId) {
            return GoodsPriceProposeErrorCode.EMPTY_COMMODITY;
        }

        if (null == this.targetAdjustPrice) {
            return GoodsPriceProposeErrorCode.EMPTY_TARGET_PRICE;
        }

        if (null == this.priceModification) {
            return GoodsPriceProposeErrorCode.EMPTY_PRICE_MODIFICATION;
        }

        if (null == this.startTime) {
            return GoodsPriceProposeErrorCode.EMPTY_START_TIME;
        }

        if (null == this.adjustReason) {
            return GoodsPriceProposeErrorCode.EMPTY_REASON;
        }
//        CommodityExample commodityExample = new CommodityExample();
//        CommodityExample.Criteria criteria = commodityExample.createCriteria();
//        criteria.andGoodsIdEqualTo(this.commodityId);
//        if (commodityMapper.selectByExample(commodityExample).size() == 0) {
//            return GoodsPriceProposeErrorCode.MISTAKE_COMMODITY;
//        }
        if (commodityMapper.selectByPrimaryKey(this.commodityId) == null) {
            return GoodsPriceProposeErrorCode.MISTAKE_COMMODITY;

        }

        return GoodsPriceProposeErrorCode.SUCCESS;
    }


    /**
     * <h2>将数据封装</h2>
     *
     * @return {@link GoodsPricePropose}
     */
    public GoodsPricePropose toGoodsPricePropose() {
        GoodsPricePropose goodsPricePropose = new GoodsPricePropose();
        goodsPricePropose.setProposerId(this.proposerId);
        goodsPricePropose.setCommodityId(this.commodityId);
        goodsPricePropose.setTargetAdjustPrice(this.targetAdjustPrice);
        goodsPricePropose.setPriceModification(this.priceModification);
        goodsPricePropose.setStartTime(this.startTime);
        goodsPricePropose.setEndTime(this.endTime);
        goodsPricePropose.setApproveStage(this.approveStage == null ? 1 : this.approveStage);
        goodsPricePropose.setApproveResult(this.approveResult == null ? false : this.approveResult);
        goodsPricePropose.setAdjustReason(this.adjustReason);
        goodsPricePropose.setProposeTime(this.proposeTime == null ? new Date() : this.proposeTime);

        return goodsPricePropose;
    }


}