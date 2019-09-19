package com.tianyi.goods.vo;

import com.tianyi.goods.constant.GoodsErrorCode;
import com.tianyi.goods.entity.Goods;
import com.tianyi.goods.mapper.GoodsBrandMapper;
import com.tianyi.goods.mapper.GoodsKindsMapper;
import com.tianyi.goods.mapper.GoodsMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateGoodsRequest {
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

    private Integer warehouseId;

    private Integer supplierId;

    private Integer businessMode;

    private String color;

    private Long stockNum;


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

        if (null == this.warehouseId) {
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
        goods.setWarehouseId(this.warehouseId);
        goods.setBusinessMode(this.businessMode);
        goods.setColor(this.color);
        goods.setSupplierId(this.supplierId);
        goods.setStockNum(this.stockNum);
        return goods;
    }


}