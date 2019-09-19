package com.tianyi.goods.vo;

import com.tianyi.goods.constant.GoodsErrorCode;
import com.tianyi.goods.entity.Goods;
import com.tianyi.goods.mapper.GoodsBrandMapper;
import com.tianyi.goods.mapper.GoodsKindsMapper;
import com.tianyi.goods.mapper.GoodsMapper;

import java.math.BigDecimal;
import java.util.Date;

public class UpdateGoodsRequest {
    private Long goodsId;

    private Long kindId;

    private String goodsName;

    private Long brandId;

    private String barcode;

    private String productModel;

    private Long purchaserId;

    private Long purchaseDepartmentId;

    private Date purchaseTime;

    private Long purchaseNum;

    private BigDecimal purchasePrice;

    private Long minimumStockNum;

    private Integer warehouseCode;

    public Integer getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(Integer warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

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
        this.goodsName = goodsName == null ? null : goodsName.trim();
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
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getMinimumStockNum() {
        return minimumStockNum;
    }

    public void setMinimumStockNum(Long minimumStockNum) {
        this.minimumStockNum = minimumStockNum;
    }


    /**
     * <h2>验证前端传来数据的有效性</h2>
     *
     * @param
     * @return {@link GoodsErrorCode 错误码}
     */
    public GoodsErrorCode validate(GoodsMapper goodsMapper, GoodsKindsMapper goodsKindsMapper, GoodsBrandMapper goodsBrandMapper) {


        if (null == this.kindId) {
            return GoodsErrorCode.EMPTY_KIND_ID;
        }
        if (goodsMapper.selectByPrimaryKey(this.goodsId) == null) {
            return GoodsErrorCode.EMPTY_GOODS;
        }

        if (null == goodsKindsMapper.selectByPrimaryKey(this.kindId)) {
            return GoodsErrorCode.MISTAKE_KIND_ID;
        }

        if (null == this.goodsName) {
            return GoodsErrorCode.EMPTY_GOODS_NAME;
        }

        if (null == this.brandId) {
            return GoodsErrorCode.EMPTY_BRAND_ID;
        }

        if (goodsBrandMapper.selectByPrimaryKey(brandId) == null) {
            return GoodsErrorCode.MISTAKE_BRAND_ID;
        }

        if (null == this.barcode) {
            return GoodsErrorCode.EMPTY_BARCODE;
        }

        if (null == this.productModel) {
            return GoodsErrorCode.EMPTY_PRODUCT_MODEL;
        }

        if (null == this.purchaserId) {
            return GoodsErrorCode.EMPTY_PURCHASER_ID;
        }

        if (null == this.purchaseDepartmentId) {
            return GoodsErrorCode.EMPTY_PURCHASE_DEPARTMENT_ID;
        }

        if (null == this.purchaseTime) {
            return GoodsErrorCode.EMPTY_PURCHASE_TIME;
        }

        if (null == this.purchaseNum) {
            return GoodsErrorCode.EMPTY_PURCHASE_NUM;
        }

        if (null == this.purchasePrice) {
            return GoodsErrorCode.EMPTY_PURCHASE_PRICE;
        }

        if (null == this.minimumStockNum) {
            return GoodsErrorCode.EMPTY_MINIMUM_STOCK_NUM;
        }

        BigDecimal num1 = new BigDecimal("0");
        if (num1.compareTo(this.purchasePrice) > 0) {
            return GoodsErrorCode.INVALID_PURCHASE_PRICE;
        }

        if (null == this.warehouseCode) {
            return GoodsErrorCode.EMPTY_WAREHOUSE_CODE;
        }

        return GoodsErrorCode.SUCCESS;

    }


    /**
     * <h2>将前端传输来的数据封装成Goods对象</h2>
     *
     * @return {@link Goods}
     */
    public Goods toGoods() {

        Goods goods = new Goods();

        goods.setGoodsId(this.goodsId);
        goods.setKindId(this.kindId);
        goods.setGoodsName(this.goodsName);
        goods.setBrandId(this.brandId);
        goods.setBarcode(this.barcode);
        goods.setProductModel(this.productModel);
        goods.setPurchaserId(this.purchaserId);
        goods.setPurchaseDepartmentId(this.purchaseDepartmentId);
        goods.setPurchaseTime(this.purchaseTime);
        goods.setPurchaseNum(this.purchaseNum);
        goods.setPurchasePrice(this.purchasePrice);
        goods.setMinimumStockNum(this.minimumStockNum);
        goods.setWarehouseId(this.warehouseCode);

        return goods;
    }


}