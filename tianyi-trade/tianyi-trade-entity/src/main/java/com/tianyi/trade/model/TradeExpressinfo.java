package com.tianyi.trade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * trade_expressinfo
 * @author 
 */
public class TradeExpressinfo implements Serializable {
    /**
     * 快递单号
     */
    private Long id;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 会员编号
     */
    private Long customerId;

    /**
     * 配送方式 ( 0 EMS\1 other)
     */
    private Integer expressType;

    /**
     * 支付方式(0货到付款、1款到发货)
     */
    private Integer payType;

    /**
     * 配送费用
     */
    private Long expressCost;

    /**
     * 汇款人
     */
    private String remitter;

    /**
     * 配送地区
     */
    private String expressAddress;

    /**
     * 邮政编号
     */
    private String postcode;

    /**
     * 收货人姓名
     */
    private String receiver;

    /**
     * 自提时间
     */
    private Date receiveTime;

    /**
     * 收货人地址
     */
    private String receiverAddress;

    /**
     * 收货人邮箱
     */
    private String receiverEmail;

    /**
     * 收货人联系电话
     */
    private String receiverContact;

    /**
     * 收货人联系手机
     */
    private String receiverMobile;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(Long expressCost) {
        this.expressCost = expressCost;
    }

    public String getRemitter() {
        return remitter;
    }

    public void setRemitter(String remitter) {
        this.remitter = remitter;
    }

    public String getExpressAddress() {
        return expressAddress;
    }

    public void setExpressAddress(String expressAddress) {
        this.expressAddress = expressAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverContact() {
        return receiverContact;
    }

    public void setReceiverContact(String receiverContact) {
        this.receiverContact = receiverContact;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        TradeExpressinfo other = (TradeExpressinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getExpressType() == null ? other.getExpressType() == null : this.getExpressType().equals(other.getExpressType()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getExpressCost() == null ? other.getExpressCost() == null : this.getExpressCost().equals(other.getExpressCost()))
            && (this.getRemitter() == null ? other.getRemitter() == null : this.getRemitter().equals(other.getRemitter()))
            && (this.getExpressAddress() == null ? other.getExpressAddress() == null : this.getExpressAddress().equals(other.getExpressAddress()))
            && (this.getPostcode() == null ? other.getPostcode() == null : this.getPostcode().equals(other.getPostcode()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getReceiverAddress() == null ? other.getReceiverAddress() == null : this.getReceiverAddress().equals(other.getReceiverAddress()))
            && (this.getReceiverEmail() == null ? other.getReceiverEmail() == null : this.getReceiverEmail().equals(other.getReceiverEmail()))
            && (this.getReceiverContact() == null ? other.getReceiverContact() == null : this.getReceiverContact().equals(other.getReceiverContact()))
            && (this.getReceiverMobile() == null ? other.getReceiverMobile() == null : this.getReceiverMobile().equals(other.getReceiverMobile()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getExpressType() == null) ? 0 : getExpressType().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getExpressCost() == null) ? 0 : getExpressCost().hashCode());
        result = prime * result + ((getRemitter() == null) ? 0 : getRemitter().hashCode());
        result = prime * result + ((getExpressAddress() == null) ? 0 : getExpressAddress().hashCode());
        result = prime * result + ((getPostcode() == null) ? 0 : getPostcode().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getReceiverAddress() == null) ? 0 : getReceiverAddress().hashCode());
        result = prime * result + ((getReceiverEmail() == null) ? 0 : getReceiverEmail().hashCode());
        result = prime * result + ((getReceiverContact() == null) ? 0 : getReceiverContact().hashCode());
        result = prime * result + ((getReceiverMobile() == null) ? 0 : getReceiverMobile().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", customerId=").append(customerId);
        sb.append(", expressType=").append(expressType);
        sb.append(", payType=").append(payType);
        sb.append(", expressCost=").append(expressCost);
        sb.append(", remitter=").append(remitter);
        sb.append(", expressAddress=").append(expressAddress);
        sb.append(", postcode=").append(postcode);
        sb.append(", receiver=").append(receiver);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverEmail=").append(receiverEmail);
        sb.append(", receiverContact=").append(receiverContact);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", note=").append(note);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}