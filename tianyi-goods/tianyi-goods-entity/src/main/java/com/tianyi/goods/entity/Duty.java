package com.tianyi.goods.entity;

public class Duty {
    private Integer dutyId;

    private String dutyName;

    private Integer dutyLevel;

    private String dutyDes;

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public Integer getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(Integer dutyLevel) {
        this.dutyLevel = dutyLevel;
    }

    public String getDutyDes() {
        return dutyDes;
    }

    public void setDutyDes(String dutyDes) {
        this.dutyDes = dutyDes == null ? null : dutyDes.trim();
    }
}