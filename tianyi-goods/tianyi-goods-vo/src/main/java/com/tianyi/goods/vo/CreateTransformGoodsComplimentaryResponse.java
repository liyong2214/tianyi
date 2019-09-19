package com.tianyi.goods.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateTransformGoodsComplimentaryResponse {
    /**
     * 创建成功返回 生成的id ，
     * 否则返回-1；
     */
    private Integer id;


}