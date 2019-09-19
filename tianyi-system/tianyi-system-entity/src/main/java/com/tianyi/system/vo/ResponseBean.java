package com.tianyi.system.vo;

import com.tianyi.system.enumModule.StatusMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : LiYong
 * @program : Response
 * @description : 返回json数据包装类
 * @date : 2019/9/8 21:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {

    // 状态码 成功200，失败
    private Integer code;

    // 状态信息
    private String message;

    // 返回的数据
    private Object data;

    public ResponseBean(StatusMessageEnum messageEnum, Object data) {
        this.code = messageEnum.getCode();
        this.message = messageEnum.getMessage();
        this.data = data;
    }
}
