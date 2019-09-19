package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 产品错误码
 * @author: Simon
 * @create: 2019-09-08 15:45
 **/
public enum GoodsErrorCode {

    SUCCESS(0, "成功"),
    MISTAKE_KIND_ID(1, "不存在该类别"),
    MISTAKE_BRAND_ID(2, "不存在该品牌"),
    EMPTY_KIND_ID(3, "缺少类别id"),
    EMPTY_GOODS_NAME(4, "缺少产品名称信息"),
    EMPTY_BRAND_ID(5, "缺少品牌id"),
    EMPTY_BARCODE(6, "缺少条形码信息"),
    EMPTY_PRODUCT_MODEL(7, "缺少产品型号信息"),
    EMPTY_PURCHASER_ID(8, "缺少采购人员信息"),
    EMPTY_PURCHASE_DEPARTMENT_ID(9, "缺少采购部门信息"),
    EMPTY_PURCHASE_TIME(10, "缺少采购时间"),
    EMPTY_PURCHASE_NUM(11, "缺少采购数量"),
    EMPTY_PURCHASE_PRICE(12, "缺少采购价格"),
    EMPTY_MINIMUM_STOCK_NUM(13, "缺少最低库存量"),
    INVALID_PURCHASE_PRICE(14, "无效采购价格"),
    EMPTY_WAREHOUSE_CODE(15, "缺少仓库code"),
    EMPTY_SEARCH_MSG(16, "缺少搜索参数"),
    EMPTY_PARAM(17, "缺少参数"),
    EMPTY_GOODS(18, "无该产品"),
    ;

    // 错误码
    private Integer code;
    //    错误描述
    private String desc;

    GoodsErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
