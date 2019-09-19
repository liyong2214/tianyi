package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateGoodsRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import com.tianyi.goods.vo.UpdateGoodsRequest;

import java.util.List;

/**
 * @program: tianyi
 * @description: goods相关service接口
 * @author: Simon
 * @create: 2019-09-08 19:32
 **/
public interface IGoodsService {


    /**
     * <h2>添加产品goods</h2>
     *
     * @param request
     * @return {返回自增id}
     */
    public Response addGoods(CreateGoodsRequest request);


    /**
     * <h2>查询产品goods</h2>
     *
     * @param nameOrId
     * @return
     */
    Response findGoodsByIdOrName(String nameOrId);


    /**
     * <h2>更新产品信息</h2>
     *
     * @param goodsRequest
     * @return
     */
    Response updateGoods(UpdateGoodsRequest goodsRequest);


    /**
     * <h2>删除goods</h2>
     *
     * @param list 参数list
     * @return
     */
    Response delGoods(List<CreateParam> list);
}




