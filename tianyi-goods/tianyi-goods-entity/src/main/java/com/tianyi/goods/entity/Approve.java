package com.tianyi.goods.entity;

public class Approve {
    private Long id;

    private Integer approveGrade;

    private Long approverId;

    private Integer approveResult;

    private Integer proposeType;

    private Integer proposeId;

    private String opinion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getApproveGrade() {
        return approveGrade;
    }

    public void setApproveGrade(Integer approveGrade) {
        this.approveGrade = approveGrade;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    public Integer getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    public Integer getProposeType() {
        return proposeType;
    }

    public void setProposeType(Integer proposeType) {
        this.proposeType = proposeType;
    }

    public Integer getProposeId() {
        return proposeId;
    }

    public void setProposeId(Integer proposeId) {
        this.proposeId = proposeId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }
}