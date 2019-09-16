package com.tianyi.trade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * trade_return_order
 * @author 
 */
public class TradeReturnOrder implements Serializable {
    /**
     * 入库单编号
     */
    private Long returnId;

    /**
     * 申请人
     */
    private String applicant;

    /**
     * 申请人联系电话
     */
    private String applicantContact;

    /**
     * 申请人联系邮箱
     */
    private String applicantEmail;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 原发货运单号
     */
    private Long expressId;

    /**
     * 原用户订单编号
     */
    private Long orderId;

    /**
     * 顾客地址
     */
    private String receiverAddress;

    /**
     * 拒收原因
     */
    private String rejection;

    /**
     * 拒收时间
     */
    private Date rejectTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantContact() {
        return applicantContact;
    }

    public void setApplicantContact(String applicantContact) {
        this.applicantContact = applicantContact;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getRejection() {
        return rejection;
    }

    public void setRejection(String rejection) {
        this.rejection = rejection;
    }

    public Date getRejectTime() {
        return rejectTime;
    }

    public void setRejectTime(Date rejectTime) {
        this.rejectTime = rejectTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TradeReturnOrder other = (TradeReturnOrder) that;
        return (this.getReturnId() == null ? other.getReturnId() == null : this.getReturnId().equals(other.getReturnId()))
            && (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
            && (this.getApplicantContact() == null ? other.getApplicantContact() == null : this.getApplicantContact().equals(other.getApplicantContact()))
            && (this.getApplicantEmail() == null ? other.getApplicantEmail() == null : this.getApplicantEmail().equals(other.getApplicantEmail()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getExpressId() == null ? other.getExpressId() == null : this.getExpressId().equals(other.getExpressId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getReceiverAddress() == null ? other.getReceiverAddress() == null : this.getReceiverAddress().equals(other.getReceiverAddress()))
            && (this.getRejection() == null ? other.getRejection() == null : this.getRejection().equals(other.getRejection()))
            && (this.getRejectTime() == null ? other.getRejectTime() == null : this.getRejectTime().equals(other.getRejectTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReturnId() == null) ? 0 : getReturnId().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getApplicantContact() == null) ? 0 : getApplicantContact().hashCode());
        result = prime * result + ((getApplicantEmail() == null) ? 0 : getApplicantEmail().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getExpressId() == null) ? 0 : getExpressId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getReceiverAddress() == null) ? 0 : getReceiverAddress().hashCode());
        result = prime * result + ((getRejection() == null) ? 0 : getRejection().hashCode());
        result = prime * result + ((getRejectTime() == null) ? 0 : getRejectTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", returnId=").append(returnId);
        sb.append(", applicant=").append(applicant);
        sb.append(", applicantContact=").append(applicantContact);
        sb.append(", applicantEmail=").append(applicantEmail);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", name=").append(name);
        sb.append(", expressId=").append(expressId);
        sb.append(", orderId=").append(orderId);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", rejection=").append(rejection);
        sb.append(", rejectTime=").append(rejectTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}