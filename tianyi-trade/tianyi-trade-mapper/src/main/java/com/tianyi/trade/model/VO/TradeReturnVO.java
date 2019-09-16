package com.tianyi.trade.model.VO;

import java.util.Date;

/**
 * 销售退货单记录
 * @author : Hens
 * @date : 2019/9/13 22:40
 */
public class TradeReturnVO {
    /**
     * 退货单序号
     */
    private Long returnId;
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 物流编号
     */
    private Long expressId;
    /**
     * 创建人
     */
    private String applicant;
    /**
     * 创建时间
     */
    private Date createTime;

    public TradeReturnVO() {
    }

    public TradeReturnVO(Long returnId, Long orderId, Long expressId, String applicant, Date createTime) {
        this.returnId = returnId;
        this.orderId = orderId;
        this.expressId = expressId;
        this.applicant = applicant;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TradeReturnVO{" +
                "returnId=" + returnId +
                ", orderId=" + orderId +
                ", expressId=" + expressId +
                ", applicant='" + applicant + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
