package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateCommodityRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import com.tianyi.goods.vo.UpdateCommodityRequest;

import java.util.List;

/**
 * @program: tianyi
 * @description: 商品service
 * @author: Simon
 * @create: 2019-09-09 16:52
 **/
public interface ICommodityService {


    /**
     * <h2>添加商品</h2>
     *
     * @param commodityRequest
     * @return {@link Response}
     */
    public Response addCommodity(CreateCommodityRequest commodityRequest);


    /**
     * @param nameId 商品name或者id模糊查询
     * @return
     */
    public Response findCommodityByNameOrId(String nameId);


    /**
     * <h2>修改商品</h2>
     *
     * @param commodityRequest 商品
     * @return
     */
    Response updateCommodity(UpdateCommodityRequest commodityRequest);


    /**
     * <h2>删除商品</h2>
     *
     * @param list
     * @return
     */
    Response delCommodity(List<CreateParam> list);
}
