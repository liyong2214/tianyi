package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: tianyi
 * @description: 返回类
 * @author: Simon
 * @create: 2019-09-08 20:47
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response {

    /**
     * 错误码, 正确返回 0
     */
    private Integer errorCode = 0;

    /**
     * 错误信息, 正确返回空字符串
     */
    private String errorMsg = "";

    /**
     * 返回值对象
     */
    private Object data;

    /**
     * <h2>正确的响应构造函数</h2>
     *
     * @param data 返回值对象
     */
    public Response(Object data) {
        this.data = data;
    }


}
