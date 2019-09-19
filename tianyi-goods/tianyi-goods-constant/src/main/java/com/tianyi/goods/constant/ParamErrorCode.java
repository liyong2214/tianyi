package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 参数错误码
 * @author: Simon
 * @create: 2019-09-12 10:57
 **/


public enum ParamErrorCode {
    SUCCESS(0, "成功"),
    EMPTY_PARAM(1, "缺少参数信息"),
    ;
    // 错误码
    private Integer code;
    //    错误描述
    private String desc;


    ParamErrorCode(Integer code, String desc) {
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
