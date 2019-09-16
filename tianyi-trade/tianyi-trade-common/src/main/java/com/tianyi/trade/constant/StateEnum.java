package com.tianyi.trade.constant;

/**
 * @author : Hens
 * @date : 2019/9/14 17:26
 */
public enum StateEnum {
    //  订单状态 0审核通过 1已付款 2 已出库 3 已发货 4 已到货 5 已归档 6 已拒收
    PASSED(0),
    PAID(1),
    OUTBOUND(2),
    DELIVERED(3),
    ARRIVED(4),
    ARCHIVED(5),
    REJECTED(6)
    ;

    private Integer state;

    StateEnum(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    private void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StateEnum{" +
                "state=" + state +
                '}';
    }
}
