package com.tianyi.trade.model.VO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
/**
 * 用于输出到页面的销售出库单
 * @author : Hens
 * @date : 2019/9/8 20:00
 */
public class TradeDeliverOrderVO {
    /**
     * 销售出库单编号
     */
    private Long deliveryId;
    /**
     * 业务类型
     */
    private Integer tradeType;
    /**
     * 多个商品信息
     */
    private List<GoodDeliverVO> goodDeliverVOs;
    /**
     * 订单类型 0电话订单 1网络订单2其他
     */
    private Integer resourceId;

    /**
     * 订单流程日志
     */
    private List<String> processContent;

    /**
     * 订单详情
     */
    private TradeOrderVO tradeOrderVO;
    /**
     * 客服备注信息
     */
    private String serviceNote;
    /**
     * 处理时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String updateTime;

    public TradeDeliverOrderVO() {
    }



    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public List<GoodDeliverVO> getGoodDeliverVOs() {
        return goodDeliverVOs;
    }

    public void setGoodDeliverVOs(List<GoodDeliverVO> goodDeliverVOs) {
        this.goodDeliverVOs = goodDeliverVOs;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public List<String> getProcessContent() {
        return processContent;
    }

    public void setProcessContent(List<String> processContent) {
        this.processContent = processContent;
    }

    public TradeOrderVO getTradeOrderVO() {
        return tradeOrderVO;
    }

    public void setTradeOrderVO(TradeOrderVO tradeOrderVO) {
        this.tradeOrderVO = tradeOrderVO;
    }

    public String getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(String serviceNote) {
        this.serviceNote = serviceNote;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
