package com.tianyi.trade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_goods
 * @author 
 */
public class TGoods implements Serializable {
    /**
     * 商品编码
     */
    private Long goodsId;

    /**
     * 类别id
     */
    private Long kindId;

    /**
     * 库存商品名称
     */
    private String goodsName;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 条形码
     */
    private String barcode;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 采购人员的id
     */
    private Long purchaserId;

    /**
     * 采购部门id
     */
    private Long purchaseDepartmentId;

    /**
     * 采购时间
     */
    private Date purchaseTime;

    /**
     * 采购数量
     */
    private Long purchaseNum;

    /**
     * 采购价格；0：供货商赠送
     */
    private Long purchasePrice;

    /**
     * 最低备货量。
     */
    private Long minimumStockNum;

    /**
     * 仓库编号
     */
    private Integer warehouseCode;

    /**
     * 供货商id
     */
    private Integer supplierId;

    private static final long serialVersionUID = 1L;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Long getPurchaseDepartmentId() {
        return purchaseDepartmentId;
    }

    public void setPurchaseDepartmentId(Long purchaseDepartmentId) {
        this.purchaseDepartmentId = purchaseDepartmentId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Long getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Long purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getMinimumStockNum() {
        return minimumStockNum;
    }

    public void setMinimumStockNum(Long minimumStockNum) {
        this.minimumStockNum = minimumStockNum;
    }

    public Integer getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(Integer warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TGoods other = (TGoods) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getKindId() == null ? other.getKindId() == null : this.getKindId().equals(other.getKindId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getBarcode() == null ? other.getBarcode() == null : this.getBarcode().equals(other.getBarcode()))
            && (this.getProductModel() == null ? other.getProductModel() == null : this.getProductModel().equals(other.getProductModel()))
            && (this.getPurchaserId() == null ? other.getPurchaserId() == null : this.getPurchaserId().equals(other.getPurchaserId()))
            && (this.getPurchaseDepartmentId() == null ? other.getPurchaseDepartmentId() == null : this.getPurchaseDepartmentId().equals(other.getPurchaseDepartmentId()))
            && (this.getPurchaseTime() == null ? other.getPurchaseTime() == null : this.getPurchaseTime().equals(other.getPurchaseTime()))
            && (this.getPurchaseNum() == null ? other.getPurchaseNum() == null : this.getPurchaseNum().equals(other.getPurchaseNum()))
            && (this.getPurchasePrice() == null ? other.getPurchasePrice() == null : this.getPurchasePrice().equals(other.getPurchasePrice()))
            && (this.getMinimumStockNum() == null ? other.getMinimumStockNum() == null : this.getMinimumStockNum().equals(other.getMinimumStockNum()))
            && (this.getWarehouseCode() == null ? other.getWarehouseCode() == null : this.getWarehouseCode().equals(other.getWarehouseCode()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getKindId() == null) ? 0 : getKindId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getBarcode() == null) ? 0 : getBarcode().hashCode());
        result = prime * result + ((getProductModel() == null) ? 0 : getProductModel().hashCode());
        result = prime * result + ((getPurchaserId() == null) ? 0 : getPurchaserId().hashCode());
        result = prime * result + ((getPurchaseDepartmentId() == null) ? 0 : getPurchaseDepartmentId().hashCode());
        result = prime * result + ((getPurchaseTime() == null) ? 0 : getPurchaseTime().hashCode());
        result = prime * result + ((getPurchaseNum() == null) ? 0 : getPurchaseNum().hashCode());
        result = prime * result + ((getPurchasePrice() == null) ? 0 : getPurchasePrice().hashCode());
        result = prime * result + ((getMinimumStockNum() == null) ? 0 : getMinimumStockNum().hashCode());
        result = prime * result + ((getWarehouseCode() == null) ? 0 : getWarehouseCode().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", kindId=").append(kindId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", brandId=").append(brandId);
        sb.append(", barcode=").append(barcode);
        sb.append(", productModel=").append(productModel);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", purchaseDepartmentId=").append(purchaseDepartmentId);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", purchaseNum=").append(purchaseNum);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", minimumStockNum=").append(minimumStockNum);
        sb.append(", warehouseCode=").append(warehouseCode);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}