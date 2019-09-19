package com.tianyi.goods.service;

import com.tianyi.goods.vo.*;

/**
 * @program: tianyi
 * @description: 商品类别添加service接口
 * @author: Simon
 * @create: 2019-09-09 09:40
 **/
public interface IGoodsKindService {


    /**
     * <h2>添加产品类别</h2>
     *
     * @param goodsKindsRequest {@link CreateGoodsKindsRequest}
     * @return {@link Response}
     */
    public Response addGoodskind(CreateGoodsKindsRequest goodsKindsRequest);


    /**
     * <h2>依据父id查询产品类别</h2>
     *
     * @param createParam
     * @return
     */
    Response findGoodskindByPid(CreateParam createParam);


    /**
     * <h2>依据id查询产品类别</h2>
     *
     * @param createParam
     * @return
     */
    Response findGoodsKindById(CreateParam createParam);

    /**
     * <h2>更新产品类型</h2>
     *
     * @param goodsKindsRequest
     * @return
     */
    Response updateGoodsKind(UpdateGoodsKindsRequest goodsKindsRequest);


    /**
     * <h2>删除产品类型</h2>
     *
     * @param createParam
     * @return
     */
    Response delGoodsKind(CreateParam createParam);
}
