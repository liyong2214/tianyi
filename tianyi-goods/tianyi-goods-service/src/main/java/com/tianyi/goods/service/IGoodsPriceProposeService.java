package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateGoodsPriceProposeRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;

/**
 * @program: tianyi
 * @description: 价格申请单service
 * @author: Simon
 * @create: 2019-09-09 20:39
 **/
public interface IGoodsPriceProposeService {


    /**
     * <h2>增加价格调整申请单</h2>
     *
     * @param goodsPriceProposeRequest
     * @return {@link Response}
     */
    public Response addGoodsPricePropose(CreateGoodsPriceProposeRequest goodsPriceProposeRequest);


    /**
     * <h2>依据id返回价格申请单的</h2>
     *
     * @param goodsPriceProposeId {参数为：goodsPricePropose表主键id}
     * @return
     */
    Response getGoodsPricePropose(CreateParam goodsPriceProposeId);
}
