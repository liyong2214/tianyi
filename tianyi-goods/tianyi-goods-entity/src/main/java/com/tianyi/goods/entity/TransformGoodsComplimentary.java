package com.tianyi.goods.entity;

public class TransformGoodsComplimentary {
    private Integer id;

    private Long goodsId;

    private Integer translationNum;

    private Integer approveState;

    private Boolean approveResult;

    private Long proposerId;

    private Integer proposeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTranslationNum() {
        return translationNum;
    }

    public void setTranslationNum(Integer translationNum) {
        this.translationNum = translationNum;
    }

    public Integer getApproveState() {
        return approveState;
    }

    public void setApproveState(Integer approveState) {
        this.approveState = approveState;
    }

    public Boolean getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Boolean approveResult) {
        this.approveResult = approveResult;
    }

    public Long getProposerId() {
        return proposerId;
    }

    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    public Integer getProposeType() {
        return proposeType;
    }

    public void setProposeType(Integer proposeType) {
        this.proposeType = proposeType;
    }
}