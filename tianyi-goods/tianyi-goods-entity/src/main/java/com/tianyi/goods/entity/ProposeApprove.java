package com.tianyi.goods.entity;

public class ProposeApprove {
    private Long id;

    private Integer proposeId;

    private Long approveId;

    private Integer proposeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProposeId() {
        return proposeId;
    }

    public void setProposeId(Integer proposeId) {
        this.proposeId = proposeId;
    }

    public Long getApproveId() {
        return approveId;
    }

    public void setApproveId(Long approveId) {
        this.approveId = approveId;
    }

    public Integer getProposeType() {
        return proposeType;
    }

    public void setProposeType(Integer proposeType) {
        this.proposeType = proposeType;
    }
}