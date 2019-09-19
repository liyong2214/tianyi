package com.tianyi.goods.vo;

import com.tianyi.goods.constant.CommodityErrorCode;
import com.tianyi.goods.entity.Commodity;
import com.tianyi.goods.mapper.CommodityMapper;
import com.tianyi.goods.mapper.GoodsMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommodityRequest {
    private Long id;
    private Long goodsId;

    private String goodsName;

    private Long kindId;

    private String goodsShortTitle;

    private String goodsLongTitle;

    private String goodsAds;

    private Double goodsWeight;

    private Date timeToMarket;

    private BigDecimal goodsMarketPrice;

    private BigDecimal goodsTianyiPrice;

    private BigDecimal goodsPromotionPrice;

    private String goodsProductionPlace;

    private Integer isPutaway;

    private String packingList;

    private String relatePhoto;

    private String relateAccessories;

    private String relateEvaluating;

    private Integer goodsComplimentary;

    private Long num;


    /**
     * @param commodityMapper
     * @return {@link CommodityErrorCode 错误码}
     */
    public CommodityErrorCode validate(CommodityMapper commodityMapper, GoodsMapper goodsMapper) {


        if (goodsMapper.selectByPrimaryKey(goodsId) == null) {
            return CommodityErrorCode.MISTAKE_GOODS_ID;
        }
        if (null == this.goodsId) {
            return CommodityErrorCode.EMPTY_GOODS_ID;
        }
        if (null == this.kindId) {
            return CommodityErrorCode.EMPTY_KIND_ID;
        }
        if (null == this.goodsShortTitle) {
            return CommodityErrorCode.EMPTY_GOODS_SHORT_TITLE;
        }
        if (null == this.goodsAds) {
            return CommodityErrorCode.EMPTY_GOODS_ADS;
        }
        if (null == this.goodsWeight) {
            return CommodityErrorCode.EMPTY_GOODS_WEIGHT;
        }
        if (null == this.timeToMarket) {
            return CommodityErrorCode.EMPTY_TIME_TO_MARKET;
        }
        if (null == this.goodsMarketPrice) {
            return CommodityErrorCode.EMPTY_GOODS_MARKET_PRICE;
        }

        if (null == this.goodsTianyiPrice) {
            return CommodityErrorCode.EMPTY_GOODS_TIANYI_PRICE;
        }
        if (null == this.goodsPromotionPrice) {
            return CommodityErrorCode.EMPTY_GOODS_PROMOTION_PRICE;
        }

        if (null == this.goodsProductionPlace) {
            return CommodityErrorCode.EMPTY_PRODUCTION_PLACE;
        }

        if (null == this.isPutaway) {
            return CommodityErrorCode.EMPTY_IS_PUTAWAY;
        }

        if (null == this.packingList) {
            return CommodityErrorCode.EMPTY_PACKING_LIST;
        }


        return CommodityErrorCode.SUCCESS;
    }


    /**
     * <h2> 将传来的数据封装成Commodity实体对象</h2>
     *
     * @return {@link Commodity}
     */
    public Commodity toCommodity() {
        Commodity commodity = new Commodity();
        commodity.setGoodsId(goodsId);
        commodity.setGoodsName(goodsName);
        commodity.setKindId(kindId);
        commodity.setGoodsShortTitle(goodsShortTitle);
        commodity.setGoodsLongTitle(goodsLongTitle);
        commodity.setGoodsAds(goodsAds);
        commodity.setGoodsWeight(goodsWeight);
        commodity.setTimeToMarket(timeToMarket);
        commodity.setGoodsMarketPrice(goodsMarketPrice);
        commodity.setGoodsTianyiPrice(goodsTianyiPrice);
        commodity.setGoodsPromotionPrice(goodsPromotionPrice);
        commodity.setIsPutaway(isPutaway);
        commodity.setPackingList(packingList);
        commodity.setRelatePhoto(relatePhoto);
        commodity.setRelateAccessories(relateAccessories);
        commodity.setRelateEvaluating(relateEvaluating);
        commodity.setGoodsComplimentary(goodsComplimentary);
        commodity.setNum(this.num);
        return commodity;

    }


}