package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: tianyi
 * @description: 创建goods返回类
 * @author: Simon
 * @create: 2019-09-08 21:16
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoodsResponse {

//   创建goods id 失败则返回-1
   private Long id;
}
