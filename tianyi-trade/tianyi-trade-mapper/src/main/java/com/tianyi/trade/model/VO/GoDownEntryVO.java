package com.tianyi.trade.model.VO;

import java.util.Date;
import java.util.List;
/**
 * 销售退货入库单
 * @author : Hens
 * @date : 2019/9/8 22:34
 */
public class GoDownEntryVO {

    /**
     * 入库单编号
     */
    private Long entryId;
    /**
     * 销售订单
     */
    private Long salerId;
    /**
     * 订单类型 电话订单，网络订单，其它
     */
    private Integer resourceId;
    /**
     * 业务类型（普通业务 号卡套餐）
     */
    private Integer tradeType;
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
     * 退货详细商品信息
     */
    private List<GoodReturnVO> goodReturnVOS;
    /**
     * 配送方式（EMS、其他）
     */
    private Integer expressType;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 原发货运单号
     */
    private Long expressId;
    /**
     * 原用户订单号
     */
    private Long orderId;
    /**
     * 顾客地址
     */
    private String receiverAddress;

    public GoDownEntryVO() {
    }

    public Long getEntryId() {
        return entryId;
    }

    @Override
    public String toString() {
        return "GoDownEntryVO{" +
                "entryId=" + entryId +
                ", salerId=" + salerId +
                ", resourceId=" + resourceId +
                ", tradeType=" + tradeType +
                ", applicant='" + applicant + '\'' +
                ", applicantContact='" + applicantContact + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", applyTime=" + applyTime +
                ", goodReturnVOS=" + goodReturnVOS +
                ", expressType=" + expressType +
                ", name='" + name + '\'' +
                ", expressId=" + expressId +
                ", orderId=" + orderId +
                ", receiverAddress='" + receiverAddress + '\'' +
                '}';
    }

    public GoDownEntryVO(Long entryId, Long salerId, Integer resourceId, Integer tradeType, String applicant, String applicantContact, String applicantEmail, Date applyTime, List<GoodReturnVO> goodReturnVOS, Integer expressType, String name, Long expressId, Long orderId, String receiverAddress) {
        this.entryId = entryId;
        this.salerId = salerId;
        this.resourceId = resourceId;
        this.tradeType = tradeType;
        this.applicant = applicant;
        this.applicantContact = applicantContact;
        this.applicantEmail = applicantEmail;
        this.applyTime = applyTime;
        this.goodReturnVOS = goodReturnVOS;
        this.expressType = expressType;
        this.name = name;
        this.expressId = expressId;
        this.orderId = orderId;
        this.receiverAddress = receiverAddress;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Long getSalerId() {
        return salerId;
    }

    public void setSalerId(Long salerId) {
        this.salerId = salerId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
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

    public List<GoodReturnVO> getGoodReturnVOS() {
        return goodReturnVOS;
    }

    public void setGoodReturnVOS(List<GoodReturnVO> goodReturnVOS) {
        this.goodReturnVOS = goodReturnVOS;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
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
}
