package com.tianyi.goods.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Commodity {
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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}