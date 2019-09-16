package com.tianyi.trade.exception;

import com.tianyi.trade.constant.TradeEnum;

/**
 * 订单执行异常
 * @author : Hens
 * @date : 2019/9/10 14:57
 */
public class OrderException extends Exception {
    private TradeEnum tradeEnum;
    private String message;

    public OrderException(String message, TradeEnum tradeEnum) {
        super(message);
        this.tradeEnum = tradeEnum;
        this.message = message;
    }

    public OrderException(String message, Throwable cause, TradeEnum tradeEnum) {
        super(message, cause);
        this.tradeEnum = tradeEnum;
        this.message = message;
    }

    public OrderException(TradeEnum tradeEnum) {
        this.tradeEnum = tradeEnum;
    }

    public TradeEnum getTradeEnum() {
        return tradeEnum;
    }

    public void setTradeEnum(TradeEnum tradeEnum) {
        this.tradeEnum = tradeEnum;
    }

    @Override
    public String toString() {
        return "订单异常{" +
                "tradeEnum=" + tradeEnum +
                ", message='" + message + '\'' +
                '}';
    }
}
