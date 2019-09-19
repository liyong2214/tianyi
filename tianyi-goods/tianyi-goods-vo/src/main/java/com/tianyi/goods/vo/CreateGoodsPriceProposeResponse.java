package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: tianyi
 * @description: 创建价格申请单返回
 * @author: Simon
 * @create: 2019-09-09 20:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateGoodsPriceProposeResponse {


    /**
     * 创建成功，则返回生成的id
     * 创建失败，返回-1
     */
    private Integer id;


    private Integer approveStage;

    private Boolean approveResult;
}
