package com.tianyi.trade.model.VO;

import com.tianyi.trade.model.TradeOrderinfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单详细资料
 * @author : Hens
 * @date : 2019/9/11 21:08
 */
public class OrderInfoVO {
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 订单类型 电话订单，网络订单，其它
     */
    private Integer resourceId;
    /**
     * 下单日期
     */
    private Date createTime;
    /**
     * 订单动作（订购 换购 支付）
     */
    private Integer actionId;
    /**
     * 业务类型（普通业务 号卡套餐）
     */
    private Integer tradeType;
    /**
     * 商品
     */
    private List<TradeOrderinfo> tradeOrderinfos;
    /**
     * 会员账号
     */
    private String username;
    /**
     * 配送方式（EMS、其他）
     */
    private Integer expressType;
    /**
     * 配送费用
     */
    private Long expressCost;
    /**
     * 配送地区
     */
    private String expressAddress;
    /**
     * 收货人名称
     */
    private String receiver;
    /**
     * 邮政编码
     */
    private String postcode;
    /**
     * 收货人地址
     */
    private String receiverAddress;
    /**
     * 电子邮箱
     */
    private String receiverEmail;
    /**
     * 联系电话
     */
    private String receiverContact;
    /**
     * 联系手机
     */
    private String receiverMobile;
    /**
     * 支付方式（货到付款，款到发货）
     */
    private Integer payType;
    /**
     * 自提时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date receiveTime;
    /**
     * 备注
     */
    private String note;
    /**
     * 汇款人
     */
    private String remitter;
    /**
     * 订单状态（审核通过，已付款，已出库，已发货，已到货，已归档）
     */
    private Integer orderState;

    public OrderInfoVO() {
    }

    public OrderInfoVO(Long orderId, Integer resourceId, Date createTime, Integer actionId, Integer tradeType, List<TradeOrderinfo> tradeOrderinfos, String username, Integer expressType, Long expressCost, String expressAddress, String receiver, String postcode, String receiverAddress, String receiverEmail, String receiverContact, String receiverMobile, Integer payType, Date receiveTime, String note, String remitter, Integer orderState) {
        this.orderId = orderId;
        this.resourceId = resourceId;
        this.createTime = createTime;
        this.actionId = actionId;
        this.tradeType = tradeType;
        this.tradeOrderinfos = tradeOrderinfos;
        this.username = username;
        this.expressType = expressType;
        this.expressCost = expressCost;
        this.expressAddress = expressAddress;
        this.receiver = receiver;
        this.postcode = postcode;
        this.receiverAddress = receiverAddress;
        this.receiverEmail = receiverEmail;
        this.receiverContact = receiverContact;
        this.receiverMobile = receiverMobile;
        this.payType = payType;
        this.receiveTime = receiveTime;
        this.note = note;
        this.remitter = remitter;
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "orderId=" + orderId +
                ", resourceId=" + resourceId +
                ", createTime=" + createTime +
                ", actionId=" + actionId +
                ", tradeType=" + tradeType +
                ", tradeOrderinfos=" + tradeOrderinfos +
                ", username='" + username + '\'' +
                ", expressType=" + expressType +
                ", expressCost=" + expressCost +
                ", expressAddress='" + expressAddress + '\'' +
                ", receiver='" + receiver + '\'' +
                ", postcode='" + postcode + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", receiverContact='" + receiverContact + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", payType=" + payType +
                ", receiveTime=" + receiveTime +
                ", note='" + note + '\'' +
                ", remitter='" + remitter + '\'' +
                ", orderState=" + orderState +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public List<TradeOrderinfo> getTradeOrderinfos() {
        return tradeOrderinfos;
    }

    public void setTradeOrderinfos(List<TradeOrderinfo> tradeOrderinfos) {
        this.tradeOrderinfos = tradeOrderinfos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    public Long getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(Long expressCost) {
        this.expressCost = expressCost;
    }

    public String getExpressAddress() {
        return expressAddress;
    }

    public void setExpressAddress(String expressAddress) {
        this.expressAddress = expressAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRemitter() {
        return remitter;
    }

    public void setRemitter(String remitter) {
        this.remitter = remitter;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}
