package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: tianyi
 * @description: 创建产品品牌返回response类
 * @author: Simon
 * @create: 2019-09-09 10:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateGoodsBrandResponse {

    /**
     * 创建成功，返回生成的id
     * 创建失败，返回 -1
     */
    private Long id;

}
