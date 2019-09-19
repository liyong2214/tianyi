package com.tianyi.goods.vo;

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
public class CreateCommodityPromotionProposeResponse {


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


}
