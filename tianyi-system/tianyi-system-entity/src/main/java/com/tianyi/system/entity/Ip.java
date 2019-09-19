package com.tianyi.system.entity;

public class Ip {
    private Integer ipId;

    private Integer deptId;

    private String ipScope;

    private Integer ipState;

    private String ipDes;

    public Integer getIpId() {
        return ipId;
    }

    public void setIpId(Integer ipId) {
        this.ipId = ipId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getIpScope() {
        return ipScope;
    }

    public void setIpScope(String ipScope) {
        this.ipScope = ipScope == null ? null : ipScope.trim();
    }

    public Integer getIpState() {
        return ipState;
    }

    public void setIpState(Integer ipState) {
        this.ipState = ipState;
    }

    public String getIpDes() {
        return ipDes;
    }

    public void setIpDes(String ipDes) {
        this.ipDes = ipDes == null ? null : ipDes.trim();
    }
}