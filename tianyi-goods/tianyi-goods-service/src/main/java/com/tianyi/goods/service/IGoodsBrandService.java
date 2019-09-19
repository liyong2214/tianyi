package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateGoodsBrandRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import com.tianyi.goods.vo.UpdateGoodsBrandRequest;

import java.util.List;

/**
 * @program: tianyi
 * @description: 产品品牌service层
 * @author: Simon
 * @create: 2019-09-09 10:54
 **/
public interface IGoodsBrandService {


    /**
     * <h2>创建产品品牌</h2>
     *
     * @param brandRequest {@link CreateGoodsBrandRequest}
     * @return {@link Response}
     */
    public Response addBrand(CreateGoodsBrandRequest brandRequest);


    /**
     * <h2>查询</h2>
     *
     * @param createParam
     * @return
     */
    Response findBrand(CreateParam createParam);


    /**
     * <h2>更新品牌信息</h2>
     *
     * @param goodsBrandRequest {@link UpdateGoodsBrandRequest 品牌VO}
     * @return
     */
    Response updateBrand(UpdateGoodsBrandRequest goodsBrandRequest);


    /**
     * <h2>删除品牌</h2>
     *
     * @param list {@link CreateParam 参数vo}
     * @return
     */
    Response delBrand(List<CreateParam> list);
}
