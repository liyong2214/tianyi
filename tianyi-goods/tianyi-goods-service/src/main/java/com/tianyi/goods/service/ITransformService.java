package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.CreateTransformGoodsComplimentaryRequest;
import com.tianyi.goods.vo.Response;

/**
 * @program: tianyi
 * @description: 商品与赠品之间的转换
 * @author: Simon
 * @create: 2019-09-14 17:14
 **/
public interface ITransformService {


    /**
     * <h2>赠品与商品间的转换申请单</h2>
     *
     * @param transformGoodsComplimentaryRequest
     * @return
     */
    Response transformPropose(CreateTransformGoodsComplimentaryRequest transformGoodsComplimentaryRequest);

    /**
     * 、
     * <h2>依据转换申请单的id，返回特定的申请单</h2>
     *
     * @param transFormProposeId { 转换申请单的id}
     * @return
     */
    Response getTransFormPropose(CreateParam transFormProposeId);
}
