package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 调价申请单错误码
 * @author: Simon
 * @create: 2019-09-09 17:50
 **/
public enum CommodityPromotionProposeErrorCode {
    SUCCESS(0, "成功"),
    EMPTY_PROPOSER(1, "缺少申请人信息"),
    EMPTY_COMMODITY(2, "缺少商品信息"),
    EMPTY_TARGET_PRICE(3, "未指定调整价格类型"),
    EMPTY_PRICE_MODIFICATION(4, "未设置打折幅度"),
    EMPTY_START_TIME(5, "未设置开始时间"),
    EMPTY_REASON(6, "未填写调整理由"),
    MISTAKE_COMMODITY(7, "目标商品不存在"),
    EMPTY_RUSH_START_TIME(8,"未设置抢购时间"),
    EMPTY_RUSH_END_TIME(9,"未设置停止时间"),

    ;
    // 错误码
    private Integer code;
    //    错误描述
    private String desc;

    CommodityPromotionProposeErrorCode(Integer code, String desc) {
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
