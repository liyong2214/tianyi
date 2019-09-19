package com.tianyi.system.entity;

import lombok.ToString;

@ToString
public class Authority {
    private Integer authorityId;

    private String authorityName;

    private String authorityDes;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityDes() {
        return authorityDes;
    }

    public void setAuthorityDes(String authorityDes) {
        this.authorityDes = authorityDes == null ? null : authorityDes.trim();
    }
}