package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: tianyi
 * @description: 生成创建产品类别response
 * @author: Simon
 * @create: 2019-09-09 09:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateGoodsKindsResponse {

    /**
     * 如果是创建成功，则返回生成id
     * 失败则返回 -1；
     */
    private Long id;

}
