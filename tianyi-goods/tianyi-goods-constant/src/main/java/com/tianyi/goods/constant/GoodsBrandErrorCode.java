package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 品牌错误码
 * @author: Simon
 * @create: 2019-09-08 17:08
 **/
public enum GoodsBrandErrorCode {

    SUCCESS(0, "成功"),
    DUPLICATE_NAME(1, "品牌名称重复"),
    EMPTY_BRAND_NAME(2, "缺少品牌名信息"),
    EMPTY_DES(3, "缺少品牌描述"),
    EMPTY_GOODS_BRAND(4, "数据库中无此品牌"),
    ;

    // 错误码
    private Integer code;
    //    错误描述
    private String desc;

    GoodsBrandErrorCode(Integer code, String desc) {
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
