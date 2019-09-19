package com.tianyi.system.entity;

import lombok.ToString;

@ToString
public class Operation {
    private Integer operationId;

    private String operationName;

    private String operationDes;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    public String getOperationDes() {
        return operationDes;
    }

    public void setOperationDes(String operationDes) {
        this.operationDes = operationDes == null ? null : operationDes.trim();
    }
}