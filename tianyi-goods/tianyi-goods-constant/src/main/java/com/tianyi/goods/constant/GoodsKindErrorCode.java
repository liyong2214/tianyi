package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 产品类别错误码
 * @author: Simon
 * @create: 2019-09-08 17:32
 **/
public enum GoodsKindErrorCode {
    SUCCESS(0, "成功"),
    DUPLICATE_NAME(1, "类别名称重复"),
    EMPTY_KIND_NAME(2, "缺少类别名称信息"),
    EMPTY_DES(3, "缺少类别描述"),
    EMPTY_PKIND_ID(4, "缺少父级类别"),
    EMPTY_KIND(5, "无此类型"),
    ;


    // 错误码
    private Integer code;
    //    错误描述
    private String desc;

    GoodsKindErrorCode(Integer code, String desc) {
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
