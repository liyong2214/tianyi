package com.tianyi.goods.service.impl;

import com.tianyi.goods.constant.GoodsErrorCode;
import com.tianyi.goods.entity.Commodity;
import com.tianyi.goods.entity.CommodityExample;
import com.tianyi.goods.entity.Goods;
import com.tianyi.goods.entity.GoodsExample;
import com.tianyi.goods.mapper.CommodityMapper;
import com.tianyi.goods.mapper.GoodsBrandMapper;
import com.tianyi.goods.mapper.GoodsKindsMapper;
import com.tianyi.goods.mapper.GoodsMapper;
import com.tianyi.goods.service.IGoodsService;
import com.tianyi.goods.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tianyi
 * @description: IGoodsService的实现类
 * @author: Simon
 * @create: 2019-09-08 19:33
 **/
@Service
@Transactional
public class GoodsServiceImpl implements IGoodsService {

    private final GoodsMapper goodsMapper;

    private final GoodsKindsMapper goodsKindsMapper;

    private final GoodsBrandMapper goodsBrandMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper, GoodsKindsMapper goodsKindsMapper, GoodsBrandMapper goodsBrandMapper) {
        this.goodsMapper = goodsMapper;
        this.goodsKindsMapper = goodsKindsMapper;
        this.goodsBrandMapper = goodsBrandMapper;
    }

    /**
     * @param createGoodsRequest
     * @return
     */
    @Override
    public Response addGoods(CreateGoodsRequest createGoodsRequest) {
        Response response = new Response();
        CreateGoodsResponse createGoodsResponse = new CreateGoodsResponse();
        GoodsErrorCode errorCode = createGoodsRequest.validate(goodsMapper, goodsKindsMapper, goodsBrandMapper);

        if (errorCode == GoodsErrorCode.SUCCESS) {
            Goods goods = createGoodsRequest.toGoods();

            int insert = goodsMapper.insert(goods);
            createGoodsResponse.setId(goods.getGoodsId());

        } else {
            createGoodsResponse.setId(-1l);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }

        response.setData(createGoodsResponse);
        return response;
    }

    /**
     * <h2>查询产品goods</h2>
     *
     * @param nameOrId
     * @return
     */
    @Override
    public Response findGoodsByIdOrName(String nameOrId) {
        Response response = new Response();
        if (nameOrId == null) {
            response.setErrorCode(GoodsErrorCode.EMPTY_SEARCH_MSG.getCode());
            response.setErrorMsg(GoodsErrorCode.EMPTY_SEARCH_MSG.getDesc());
            return response;
        }

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        try {
            criteria.andGoodsIdEqualTo(Long.valueOf(nameOrId));
        } catch (NumberFormatException e) {

        }
        GoodsExample.Criteria criteria1 = goodsExample.createCriteria();
        criteria1.andGoodsNameLike("%" + nameOrId + "%");

        goodsExample.or(criteria1);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);

        response.setData(goods);
        return response;
    }


    /**
     * <h2>更新产品信息</h2>
     *
     * @param goodsRequest
     * @return
     */
    @Override
    public Response updateGoods(UpdateGoodsRequest goodsRequest) {
        Response response = new Response();
        GoodsErrorCode errorCode = goodsRequest.validate(goodsMapper, goodsKindsMapper, goodsBrandMapper);

        if (errorCode != GoodsErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
            return response;
        } else {
            Goods goods = goodsRequest.toGoods();
            int i = goodsMapper.updateByPrimaryKey(goods);


            if (i > 0) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CommodityExample commodityExample = new CommodityExample();
                        CommodityExample.Criteria criteria = commodityExample.createCriteria();
                        criteria.andGoodsIdEqualTo(goods.getGoodsId());
                        List<Commodity> commodities = commodityMapper.selectByExample(commodityExample);
                        for (Commodity commodity : commodities) {
                            commodity.setKindId(goods.getKindId());
                            commodityMapper.updateByPrimaryKey(commodity);
                        }
                    }
                });

            }
            response.setData(goods);
        }


        return response;
    }

    /**
     * <h2>依据参数集合删除</h2>
     *
     * @param list 参数list
     * @return
     */
    @Override
    public Response delGoods(List<CreateParam> list) {
        Response response = new Response();
        if (list.size() == 0) {
            response.setErrorCode(GoodsErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(GoodsErrorCode.EMPTY_PARAM.getDesc());
            return response;
        } else {

            try {
                int delNum = 0;
                List<Long> paramList = new ArrayList<>();
                for (CreateParam createParam : list) {
                    paramList.add(Long.valueOf(createParam.getParam()));
                }

                for (Long id : paramList) {
                    int i = goodsMapper.deleteByPrimaryKey(id);
                    if (i > 0) {
                        delNum++;
                        CommodityExample commodityExample = new CommodityExample();
                        CommodityExample.Criteria criteria = commodityExample.createCriteria();
                        criteria.andGoodsIdEqualTo(id);
                        List<Commodity> commodities = commodityMapper.selectByExample(commodityExample);
                        for (Commodity commodity : commodities) {
                            commodity.setIsPutaway(0);
                            commodityMapper.updateByPrimaryKey(commodity);
                        }

                    }

                }
                response.setData(delNum);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


        return response;
    }
}
