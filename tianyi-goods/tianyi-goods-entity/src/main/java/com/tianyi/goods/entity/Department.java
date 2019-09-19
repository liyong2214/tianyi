package com.tianyi.goods.entity;

public class Department {
    private Integer deptId;

    private String deptName;

    private Integer pDeptId;

    private String deptDes;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getpDeptId() {
        return pDeptId;
    }

    public void setpDeptId(Integer pDeptId) {
        this.pDeptId = pDeptId;
    }

    public String getDeptDes() {
        return deptDes;
    }

    public void setDeptDes(String deptDes) {
        this.deptDes = deptDes == null ? null : deptDes.trim();
    }
}