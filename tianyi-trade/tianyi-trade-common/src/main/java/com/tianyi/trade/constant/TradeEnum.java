package com.tianyi.trade.constant;

/**
 * @author : Hens
 * @date : 2019/9/10 15:00
 */
public enum TradeEnum {
    // 添加信息到数据库失败
    ORDER_INSERT_FAILURE("0001","添加数据失败"),

    ;
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
