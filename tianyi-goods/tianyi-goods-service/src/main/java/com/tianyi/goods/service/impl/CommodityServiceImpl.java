package com.tianyi.goods.service.impl;

import com.tianyi.goods.constant.CommodityErrorCode;
import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.entity.Commodity;
import com.tianyi.goods.entity.CommodityExample;
import com.tianyi.goods.mapper.CommodityMapper;
import com.tianyi.goods.mapper.GoodsMapper;
import com.tianyi.goods.service.ICommodityService;
import com.tianyi.goods.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tianyi
 * @description: 商品service实现类
 * @author: Simon
 * @create: 2019-09-09 16:54
 **/

@Service
@Transactional
public class CommodityServiceImpl implements ICommodityService {


    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * <h2>添加商品</h2>
     *
     * @param commodityRequest
     * @return {@link Response}
     */
    @Override
    public Response addCommodity(CreateCommodityRequest commodityRequest) {
        Response response = new Response();
        CreateCommodityResponse commodityResponse = new CreateCommodityResponse();
        CommodityErrorCode errorCode = commodityRequest.validate(commodityMapper, goodsMapper);

        if (errorCode != CommodityErrorCode.SUCCESS) {

            commodityResponse.setId(-1l);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {
            Commodity commodity = commodityRequest.toCommodity();
            int insert = commodityMapper.insert(commodity);

            commodityResponse.setId(commodity.getId());
            commodityResponse.setCommodityName(commodity.getGoodsName());
            commodityResponse.setGoodsId(commodity.getGoodsId());


        }
        response.setData(commodityResponse);

        return response;
    }

    /**
     * <h2>    商品name或者id模糊查询</h2>
     *
     * @param nameId
     * @return
     */
    @Override
    public Response findCommodityByNameOrId(String nameId) {
        Response response = new Response();
        if (nameId == null) {
            response.setErrorCode(CommodityErrorCode.EMPTY_SEARCH.getCode());
            response.setErrorMsg(CommodityErrorCode.EMPTY_SEARCH.getDesc());
            return response;
        }

        CommodityExample commodityExample = new CommodityExample();

        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        try {
            criteria.andGoodsIdEqualTo(Long.valueOf(nameId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        CommodityExample.Criteria criteria1 = commodityExample.createCriteria();
        criteria1.andGoodsNameLike("%" + nameId + "%");
        commodityExample.or(criteria1);

        List<Commodity> commodities = commodityMapper.selectByExample(commodityExample);
        response.setData(commodities);
        return response;
    }


    /**
     * @param commodityRequest 商品
     * @return
     */
    @Override
    public Response updateCommodity(UpdateCommodityRequest commodityRequest) {
        Response response = new Response();
        CommodityErrorCode errorCode = commodityRequest.validate(commodityMapper, goodsMapper);

        if (errorCode != CommodityErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
            return response;
        }

        Commodity commodity = commodityRequest.toCommodity();
        int i = commodityMapper.updateByPrimaryKey(commodity);
        response.setData(commodity);


        return response;
    }

    /**
     * @param list
     * @return
     */
    @Override
    public Response delCommodity(List<CreateParam> list) {
        Response response = new Response();
        if (list.size() == 0) {
            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
            return response;
        }

        int delNum = 0;
        for (CreateParam param : list) {
            String id = param.getParam();
            try {
                int i = commodityMapper.deleteByPrimaryKey(Long.valueOf(id));
                if (i > 0) {
                    delNum++;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.setData(delNum);

        return response;
    }
}
