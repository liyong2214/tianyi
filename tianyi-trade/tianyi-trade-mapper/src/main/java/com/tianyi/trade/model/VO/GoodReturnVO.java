package com.tianyi.trade.model.VO;

/**
 * EMS退货单商品信息
 * @author : Hens
 * @date : 2019/9/9 19:36
 */
public class GoodReturnVO {
    /**
     * 商品编码
     */
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
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
    /**
     * 供货商
     */
    private String supplierName;

    public GoodReturnVO() {
    }

    @Override
    public String toString() {
        return "GoodReturnVO{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsAmount=" + goodsAmount +
                ", productModel='" + productModel + '\'' +
                ", goodsSeries='" + goodsSeries + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public GoodReturnVO(Long goodsId, String goodsName, Integer goodsAmount, String productModel, String goodsSeries, String supplierName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsAmount = goodsAmount;
        this.productModel = productModel;
        this.goodsSeries = goodsSeries;
        this.supplierName = supplierName;
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
        this.goodsName = goodsName;
    }

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


}
