package com.tianyi.goods.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.tianyi.goods.constant.GoodsKindErrorCode;
import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.entity.Goods;
import com.tianyi.goods.entity.GoodsKinds;
import com.tianyi.goods.entity.GoodsKindsExample;
import com.tianyi.goods.mapper.GoodsKindsMapper;
import com.tianyi.goods.service.IGoodsKindService;
import com.tianyi.goods.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tianyi
 * @description: 产品类别实现类
 * @author: Simon
 * @create: 2019-09-09 09:45
 **/
@Service
@Transactional
public class GoodsKindServiceImpl implements IGoodsKindService {

    private final GoodsKindsMapper goodsKindsMapper;

    @Autowired
    public GoodsKindServiceImpl(GoodsKindsMapper goodsKindsMapper) {
        this.goodsKindsMapper = goodsKindsMapper;
    }

    @Override
    public Response addGoodskind(CreateGoodsKindsRequest goodsKindsRequest) {


        Response response = new Response();
        CreateGoodsKindsResponse goodsKindsResponse = new CreateGoodsKindsResponse();
        GoodsKindErrorCode errorCode = goodsKindsRequest.validate(goodsKindsMapper);
        if (errorCode != GoodsKindErrorCode.SUCCESS) {
            goodsKindsResponse.setId(-1l);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {
            GoodsKinds goodsKinds = goodsKindsRequest.toGoodsKinds();
            int insert = goodsKindsMapper.insert(goodsKinds);

            goodsKindsResponse.setId(goodsKinds.getKindId());
        }
        response.setData(goodsKindsResponse);

        return response;
    }


    /**
     * <h2>依据父id查询产品类别</h2>
     *
     * @param createParam
     * @return
     */
    @Override
    public Response findGoodskindByPid(CreateParam createParam) {
        Response response = new Response();
        if (createParam.getParam() == null) {
            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
            return response;
        }
        GoodsKindsExample goodsKindsExample = new GoodsKindsExample();
        GoodsKindsExample.Criteria criteria = goodsKindsExample.createCriteria();
        try {
            criteria.andPKindIdEqualTo(Long.valueOf(createParam.getParam()));

            List<GoodsKinds> goodsKinds = goodsKindsMapper.selectByExample(goodsKindsExample);
            response.setData(goodsKinds);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * <h2>依据id查询产品类别</h2>
     *
     * @param createParam
     * @return
     */
    @Override
    public Response findGoodsKindById(CreateParam createParam) {

        Response response = new Response();
        if (createParam.getParam() == null) {

            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
            return response;

        }

        String param = createParam.getParam();
        try {
            GoodsKinds goodsKinds = goodsKindsMapper.selectByPrimaryKey(Long.valueOf(param));
            response.setData(goodsKinds);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        return response;
    }



    /**
     * <h2>更新产品类型</h2>
     *
     * @param goodsKindsRequest
     * @return
     */

    @Override
    public Response updateGoodsKind(UpdateGoodsKindsRequest goodsKindsRequest) {
        Response response = new Response();
        GoodsKindErrorCode errorCode = goodsKindsRequest.validate(goodsKindsMapper);
        if (errorCode != GoodsKindErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
            return response;
        }
        GoodsKinds goodsKinds = goodsKindsRequest.toGoodsKinds();
        int i = goodsKindsMapper.updateByPrimaryKey(goodsKinds);
        response.setData(i);
        return response;
    }


    /**
     * <h2>删除产品类型</h2>
     *
     * @param createParam
     * @return
     */
    @Override
    public Response delGoodsKind(CreateParam createParam) {
        Response response = new Response();
        if (createParam.getParam() == null) {
            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
            return response;
        }
        int i = 0;
        try {
            i = goodsKindsMapper.deleteByPrimaryKey(Long.valueOf(createParam.getParam()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (i > 0) {
            response.setData(i);
        }

        return response;
    }
}
