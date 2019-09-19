package com.tianyi.goods.constant;

/**
 * @program: tianyi
 * @description: 审批错误码
 * @author: Simon
 * @create: 2019-09-08 11:43
 **/
public enum ApproveErrorCode {
    SUCCESS(0, "成功"),
    EMPTY_GRADE(1, "缺少审批级别"),
    EMPTY_APPROVER(2, "缺少审批人"),
    EMPTY_RESULT(3, "缺少审批结果"),
    EMPTY_OPINION(4, "缺少审批意见"),
    EMPTY_AUTHORITY(5, "缺少审批权限"),
    EMPTY_PROPOSE_ID(6, "缺少申请单"),
    EMPTY_PROPOSE_TYPE(7, "缺少申请单类型号"),
    ;


    //    错误码
    private Integer code;
    //    错误描述
    private String desc;

    ApproveErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
