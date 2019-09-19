package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 商品信息错误码
 * @author: Simon
 * @create: 2019-09-08 14:47
 **/
public enum CommodityErrorCode {
    SUCCESS(0, "成功"),
    MISTAKE_GOODS_ID(1, "库存无指定id产品"),
    EMPTY_GOODS_NAME(2, "无商品名"),
    EMPTY_GOODS_ID(3, "无商品id"),
    EMPTY_KIND_ID(4, "无类别id"),
    EMPTY_GOODS_SHORT_TITLE(5, "无商品短标题"),
    EMPTY_GOODS_LONG_TITLE(6, "无商品长标题"),
    EMPTY_GOODS_ADS(7, "无商品广告词"),
    EMPTY_GOODS_WEIGHT(8, "无商品重量"),
    EMPTY_TIME_TO_MARKET(9, "无上市时间"),
    EMPTY_GOODS_MARKET_PRICE(10, "无市场价格"),
    EMPTY_GOODS_TIANYI_PRICE(11, "无天翼价格"),
    EMPTY_GOODS_PROMOTION_PRICE(12, "无促销价格"),
    EMPTY_PRODUCTION_PLACE(13, "无产地信息"),
    EMPTY_IS_PUTAWAY(14, "未指定商品是否上架"),
    EMPTY_PACKING_LIST(15, "无包装清单信息"),
    EMPTY_SEARCH(16, "无查询参数信息"),
    EMPTY_COMMODITY(17, "无该商品"),
    ;
    // 错误码
    private Integer code;
    //    错误描述
    private String desc;

    CommodityErrorCode(Integer code, String desc) {
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
