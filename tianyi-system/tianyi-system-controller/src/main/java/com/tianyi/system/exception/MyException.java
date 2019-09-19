package com.tianyi.system.exception;


import com.tianyi.system.enumModule.StatusMessageEnum;

/**
 * @author : LiYong
 * @program : MyException
 * @description : 自定义异常
 * @date : 2019/9/12 23:11
 */
public class MyException extends RuntimeException {

    // 状态枚举
    private StatusMessageEnum statusMessageEnum;

    public MyException(StatusMessageEnum statusMessageEnum) {
        this.statusMessageEnum = statusMessageEnum;
    }

    public StatusMessageEnum getStatusMessageEnum() {
        return statusMessageEnum;
    }

    public void setStatusMessageEnum(StatusMessageEnum statusMessageEnum) {
        this.statusMessageEnum = statusMessageEnum;
    }
}
