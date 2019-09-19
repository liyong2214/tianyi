package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateCommodityPromotionProposeRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;

/**
 * @program: tianyi
 * @description: 促销价格申请单
 * @author: Simon
 * @create: 2019-09-13 22:54
 **/
public interface ICommodityPromotionProposeService {


    /**
     * <h2>生成商品价格促销申请单</h2>
     *
     * @param commodityPromotionPropose {@link CreateCommodityPromotionProposeRequest 商品价格促销申请单VO}
     * @return
     */
    Response addCommodityPromotionPropose(CreateCommodityPromotionProposeRequest commodityPromotionPropose);


    /**
     * <h2>依据主键id，返回对应的CommodityPromotionPropose表</h2>
     * @param id {@link CreateParam  存值为CommodityPromotionProposeId表的主键id}
     * @return
     */
    Response getCommodityPromotionPropose(Integer id);
}
