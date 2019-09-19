package com.tianyi.system.vo;

/**
 * @author : LiYong
 * @program : ExceptionBean
 * @description : 返回异常实体类
 * @date : 2019/9/12 23:16
 */
public class ExceptionBean {

    private int code;
    private String message;

    private long time;

    public ExceptionBean(int code, String message) {
        this.code = code;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "ExceptionBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
