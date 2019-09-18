package com.tianyi.trade.model.VO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 销售出库单中的商品信息
 * @author : Hens
 * @date : 2019/9/8 21:37
 */
public class GoodDeliverVO {
    /**
     * 购买商品id
     */
    private Long goodsId;
    /**
     * 商品品牌
     */
    private String brandName;
    /**
     * 商品型号
     */
    private String kindName;
    /**
     * 出库数量
     */
    private Integer goodsAmount;
    /**
     * 单价
     */
    private Long goodsPrice;
    /**
     * 出库仓库
     */
    private Integer warehouseCode;
    /**
     * 机型
     */
    private String productModel;
    /**
     * 机型串号
     */
    private String goodsSeries;
    /**
     * 供货商
     */
    private String supplier;
    /**
     * 入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    public GoodDeliverVO() {
    }

    public GoodDeliverVO(Long goodsId, String brandName, String kindName, Integer goodsAmount, Long goodsPrice, Integer warehouseCode, String productModel, String goodsSeries, String supplier, Date createTime) {
        this.goodsId = goodsId;
        this.brandName = brandName;
        this.kindName = kindName;
        this.goodsAmount = goodsAmount;
        this.goodsPrice = goodsPrice;
        this.warehouseCode = warehouseCode;
        this.productModel = productModel;
        this.goodsSeries = goodsSeries;
        this.supplier = supplier;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GoodDeliverVO{" +
                "goodsId=" + goodsId +
                ", brandName='" + brandName + '\'' +
                ", kindName='" + kindName + '\'' +
                ", goodsAmount=" + goodsAmount +
                ", goodsPrice=" + goodsPrice +
                ", warehouseCode=" + warehouseCode +
                ", productModel='" + productModel + '\'' +
                ", goodsSeries='" + goodsSeries + '\'' +
                ", supplier='" + supplier + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(Integer warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
}
