package com.tianyi.trade.model.VO;

import java.util.Date;
import java.util.List;
/**
 * 从中邮接收的退货单
 * @author : Hens
 * @date : 2019/9/9 10:12
 */
public class EMSReturnVO {
    /**
     * EMS退货订单编号
     */
    private Long EMSReturnId;
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
     * 传入的商品信息
     */
    private List<GoodReturnVO> goodReturnVOS;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 原发货快递单号
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

    public EMSReturnVO() {
    }

    @Override
    public String toString() {
        return "EMSReturnVO{" +
                "EMSReturnId=" + EMSReturnId +
                ", applicant='" + applicant + '\'' +
                ", applicantContact='" + applicantContact + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", applyTime=" + applyTime +
                ", goodReturnVOS=" + goodReturnVOS +
                ", name='" + name + '\'' +
                ", expressId=" + expressId +
                ", orderId=" + orderId +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", rejection='" + rejection + '\'' +
                ", rejectTime=" + rejectTime +
                '}';
    }

    public EMSReturnVO(Long EMSReturnId, String applicant, String applicantContact, String applicantEmail, Date applyTime, List<GoodReturnVO> goodReturnVOS, String name, Long expressId, Long orderId, String receiverAddress, String rejection, Date rejectTime) {
        this.EMSReturnId = EMSReturnId;
        this.applicant = applicant;
        this.applicantContact = applicantContact;
        this.applicantEmail = applicantEmail;
        this.applyTime = applyTime;
        this.goodReturnVOS = goodReturnVOS;
        this.name = name;
        this.expressId = expressId;
        this.orderId = orderId;
        this.receiverAddress = receiverAddress;
        this.rejection = rejection;
        this.rejectTime = rejectTime;
    }

    public List<GoodReturnVO> getGoodReturnVOS() {
        return goodReturnVOS;
    }

    public void setGoodReturnVOS(List<GoodReturnVO> goodReturnVOS) {
        this.goodReturnVOS = goodReturnVOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getEMSReturnId() {
        return EMSReturnId;
    }

    public void setEMSReturnId(Long EMSReturnId) {
        this.EMSReturnId = EMSReturnId;
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
}
