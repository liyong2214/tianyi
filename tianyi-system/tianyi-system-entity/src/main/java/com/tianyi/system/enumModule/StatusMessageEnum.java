package com.tianyi.system.enumModule;

/**
 * @author : LiYong
 * @program : StatusMessageEnum
 * @description : 异常状态码，状态信息
 * @date : 2019/9/12 23:05
 */
public enum StatusMessageEnum {

    BYZERO(200001,"除零错误"),
    SERVER_ERROR(20002,"服务器正忙"),
    SUCCESS(200,"获取数据成功"),
    NUll_PARAM(20009,"参数为NULL")
    ;


    private int code;
    private String message;

    StatusMessageEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
