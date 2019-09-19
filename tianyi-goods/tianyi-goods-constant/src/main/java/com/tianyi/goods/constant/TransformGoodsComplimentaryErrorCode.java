package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: TransformGoodsComplimentary數據相關錯誤碼
 * @author: Simon
 * @create: 2019-09-14 16:11
 **/
public enum TransformGoodsComplimentaryErrorCode {
    SUCCESS(0, "成功"),
    EMPTY_GOODS_ID(1, "缺少产品id"),
    EMPTY_TRANSLATION_NUM(2, "缺少转换数量"),
    EMPTY_PROPOSER(3, "缺少申请人"),
    MISTAKE_GOODS(4, "不存在该产品"),
    MISTAKE_TRANSLATION_NUM(5, "转化数量不能超过现有库存量"),
    ;
    // 错误码
    private Integer code;
    //    错误描述
    private String desc;


    TransformGoodsComplimentaryErrorCode(Integer code, String desc) {
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
