package com.tianyi.goods.vo;

import com.tianyi.goods.constant.CommodityErrorCode;
import com.tianyi.goods.entity.Commodity;
import com.tianyi.goods.mapper.CommodityMapper;
import com.tianyi.goods.mapper.GoodsMapper;

import java.math.BigDecimal;
import java.util.Date;

public class UpdateCommodityRequest {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getGoodsShortTitle() {
        return goodsShortTitle;
    }

    public void setGoodsShortTitle(String goodsShortTitle) {
        this.goodsShortTitle = goodsShortTitle == null ? null : goodsShortTitle.trim();
    }

    public String getGoodsLongTitle() {
        return goodsLongTitle;
    }

    public void setGoodsLongTitle(String goodsLongTitle) {
        this.goodsLongTitle = goodsLongTitle == null ? null : goodsLongTitle.trim();
    }

    public String getGoodsAds() {
        return goodsAds;
    }

    public void setGoodsAds(String goodsAds) {
        this.goodsAds = goodsAds == null ? null : goodsAds.trim();
    }

    public Double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public Date getTimeToMarket() {
        return timeToMarket;
    }

    public void setTimeToMarket(Date timeToMarket) {
        this.timeToMarket = timeToMarket;
    }

    public BigDecimal getGoodsMarketPrice() {
        return goodsMarketPrice;
    }

    public void setGoodsMarketPrice(BigDecimal goodsMarketPrice) {
        this.goodsMarketPrice = goodsMarketPrice;
    }

    public BigDecimal getGoodsTianyiPrice() {
        return goodsTianyiPrice;
    }

    public void setGoodsTianyiPrice(BigDecimal goodsTianyiPrice) {
        this.goodsTianyiPrice = goodsTianyiPrice;
    }

    public BigDecimal getGoodsPromotionPrice() {
        return goodsPromotionPrice;
    }

    public void setGoodsPromotionPrice(BigDecimal goodsPromotionPrice) {
        this.goodsPromotionPrice = goodsPromotionPrice;
    }

    public String getGoodsProductionPlace() {
        return goodsProductionPlace;
    }

    public void setGoodsProductionPlace(String goodsProductionPlace) {
        this.goodsProductionPlace = goodsProductionPlace == null ? null : goodsProductionPlace.trim();
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList == null ? null : packingList.trim();
    }

    public String getRelatePhoto() {
        return relatePhoto;
    }

    public void setRelatePhoto(String relatePhoto) {
        this.relatePhoto = relatePhoto == null ? null : relatePhoto.trim();
    }

    public String getRelateAccessories() {
        return relateAccessories;
    }

    public void setRelateAccessories(String relateAccessories) {
        this.relateAccessories = relateAccessories == null ? null : relateAccessories.trim();
    }

    public String getRelateEvaluating() {
        return relateEvaluating;
    }

    public void setRelateEvaluating(String relateEvaluating) {
        this.relateEvaluating = relateEvaluating == null ? null : relateEvaluating.trim();
    }

    public Integer getGoodsComplimentary() {
        return goodsComplimentary;
    }

    public void setGoodsComplimentary(Integer goodsComplimentary) {
        this.goodsComplimentary = goodsComplimentary;
    }


    /**
     * @param commodityMapper
     * @return {@link CommodityErrorCode 错误码}
     */
    public CommodityErrorCode validate(CommodityMapper commodityMapper, GoodsMapper goodsMapper) {

        if (commodityMapper.selectByPrimaryKey(this.id) == null) {
            return CommodityErrorCode.EMPTY_COMMODITY;
        }
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
        commodity.setId(this.id);
        commodity.setGoodsId(this.goodsId);
        commodity.setGoodsName(this.goodsName);
        commodity.setKindId(this.kindId);
        commodity.setGoodsShortTitle(this.goodsShortTitle);
        commodity.setGoodsLongTitle(this.goodsLongTitle);
        commodity.setGoodsAds(this.goodsAds);
        commodity.setGoodsWeight(this.goodsWeight);
        commodity.setTimeToMarket(this.timeToMarket);
        commodity.setGoodsMarketPrice(this.goodsMarketPrice);
        commodity.setGoodsTianyiPrice(this.goodsTianyiPrice);
        commodity.setGoodsPromotionPrice(this.goodsPromotionPrice);
        commodity.setIsPutaway(this.isPutaway);
        commodity.setPackingList(this.packingList);
        commodity.setRelatePhoto(this.relatePhoto);
        commodity.setRelateAccessories(this.relateAccessories);
        commodity.setRelateEvaluating(this.relateEvaluating);
        commodity.setGoodsComplimentary(this.goodsComplimentary);

        return commodity;

    }


}