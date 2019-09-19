package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: tianyi
 * @description: 创建商品response
 * @author: Simon
 * @create: 2019-09-09 16:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateCommodityResponse {

    /**
     * 若创建失败则返回-1
     * 创建成功，返回自增id
     */
    private Long id;

    private Long goodsId;
    private String commodityName;


}
