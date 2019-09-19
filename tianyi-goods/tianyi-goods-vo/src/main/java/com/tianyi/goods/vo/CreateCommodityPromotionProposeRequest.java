package com.tianyi.goods.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tianyi.goods.constant.CommodityPromotionProposeErrorCode;
import com.tianyi.goods.entity.CommodityPromotionPropose;
import com.tianyi.goods.mapper.CommodityMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: tianyi
 * @description: 创建CommodityPromotionPropose
 * @author: Simon
 * @create: 2019-09-13 22:55
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateCommodityPromotionProposeRequest {


    private Integer id;

    private Long proposerId;

    private Long commodityId;

    private BigDecimal goodsPurchasePrice;

    private String goodsWarehouseDistribute;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rushShoppingStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rushShoppingEndTime;

    private BigDecimal priceModificationAbsolute;

    private Float priceModificationRelative;

    private Integer targetAdjustPrice;

    private Integer approveStage;

    private Boolean approveResult;

    private Date proposeTime;

    private Integer proposeType;

    private String adjustReason;


    /**
     * <h2>验证数据的有效性</h2>
     *
     * @param commodityMapper
     * @return
     */
    public CommodityPromotionProposeErrorCode validate(CommodityMapper commodityMapper) {

        if (null == this.proposerId) {

            return CommodityPromotionProposeErrorCode.EMPTY_PROPOSER;
        }
        if (null == this.commodityId) {
            return CommodityPromotionProposeErrorCode.EMPTY_COMMODITY;

        }
        if (null == this.rushShoppingStartTime) {
            return CommodityPromotionProposeErrorCode.EMPTY_RUSH_START_TIME;
        }
        if (null == this.rushShoppingEndTime) {
            return CommodityPromotionProposeErrorCode.EMPTY_RUSH_END_TIME;
        }
        if (commodityMapper.selectByPrimaryKey(this.commodityId) == null) {
            return CommodityPromotionProposeErrorCode.MISTAKE_COMMODITY;
        }
        if (null == this.targetAdjustPrice) {
            return CommodityPromotionProposeErrorCode.EMPTY_TARGET_PRICE;
        }
        if (null == this.adjustReason) {
            return CommodityPromotionProposeErrorCode.EMPTY_REASON;
        }


        return CommodityPromotionProposeErrorCode.SUCCESS;


    }

    /**
     * <h2>实现数据的封装</h2>
     *
     * @return
     */
    public CommodityPromotionPropose toCommodityPromotionPropose() {
        CommodityPromotionPropose commodityPromotionPropose = new CommodityPromotionPropose();

        commodityPromotionPropose.setCommodityId(this.commodityId);
        commodityPromotionPropose.setProposerId(this.proposerId);
        commodityPromotionPropose.setGoodsPurchasePrice(this.goodsPurchasePrice);
        commodityPromotionPropose.setGoodsWarehouseDistribute(this.goodsWarehouseDistribute);
        commodityPromotionPropose.setRushShoppingStartTime(this.rushShoppingStartTime);
        commodityPromotionPropose.setRushShoppingEndTime(this.rushShoppingEndTime);
        commodityPromotionPropose.setPriceModificationAbsolute(this.priceModificationAbsolute);
        commodityPromotionPropose.setPriceModificationRelative(this.priceModificationRelative);
        commodityPromotionPropose.setTargetAdjustPrice(this.targetAdjustPrice);
        commodityPromotionPropose.setApproveStage(this.approveStage==null?1:this.approveStage);
        commodityPromotionPropose.setApproveResult(this.approveResult==null?false:this.approveResult);
        commodityPromotionPropose.setProposeTime(new Date());
        commodityPromotionPropose.setProposeType(2);
        commodityPromotionPropose.setAdjustReason(this.adjustReason);

        return commodityPromotionPropose;

    }

}
