package com.tianyi.goods.entity;

public class GoodsKinds {
    private Long kindId;

    private String kindName;

    private Long pKindId;

    private String des;

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public Long getpKindId() {
        return pKindId;
    }

    public void setpKindId(Long pKindId) {
        this.pKindId = pKindId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
}