package com.tianyi.trade.constant;

/**
 * @author : Hens
 * @date : 2019/9/10 15:00
 */
public enum TradeEnum {
    // 添加信息到数据库失败
    ORDER_INSERT_FAILURE("001","添加数据失败"),

    /** 数据已存在 */
    SUCCESS_IS_HAVE("208", "数据已存在"),

    /** 没有结果 */
    NOT_DATA("911", "没有结果"),

    /** 没有登录 */
    NOT_LOGIN("600", "没有登录"),

    /** 发生异常 */
    EXCEPTION("401", "发生异常"),

    /** 系统错误 */
    SYS_ERROR("402", "系统错误"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误 "),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED("410", "不支持或已经废弃"),

    /** AuthCode错误 */
    INVALID_AUTHCODE("444", "无效的AuthCode"),

    /** 太频繁的调用 */
    TOO_FREQUENT("445", "太频繁的调用"),

    /** 未知的错误 */
    UNKNOWN_ERROR("499", "未知错误"),

    /** 未设置方法 */
    NOT_METHOD("4004", "未设置方法");

    private String code;
    private String message;

    TradeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(String code){
        for (TradeEnum t:TradeEnum.values()){
            if(t.getCode().equals(code)){
                return t.getMessage();
            }
        }
        return null;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
