package com.tianyi.goods.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tianyi.goods.constant.GoodsBrandErrorCode;
import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.entity.GoodsBrand;
import com.tianyi.goods.entity.GoodsBrandExample;
import com.tianyi.goods.mapper.GoodsBrandMapper;
import com.tianyi.goods.service.IGoodsBrandService;
import com.tianyi.goods.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tianyi
 * @description: GoodsBrandService 实现类
 * @author: Simon
 * @create: 2019-09-09 10:55
 **/
@Service
@Transactional
public class GoodsBrandServiceImpl implements IGoodsBrandService {

    private final GoodsBrandMapper goodsBrandMapper;

    @Autowired
    public GoodsBrandServiceImpl(GoodsBrandMapper goodsBrandMapper) {
        this.goodsBrandMapper = goodsBrandMapper;
    }


    /**
     * <h2>创建产品品牌</h2>
     *
     * @param brandRequest {@link CreateGoodsBrandRequest}
     * @return {@link Response}
     */
    @Override
    public Response addBrand(CreateGoodsBrandRequest brandRequest) {
        Response response = new Response();
        CreateGoodsBrandResponse brandResponse = new CreateGoodsBrandResponse();
        GoodsBrandErrorCode errorCode = brandRequest.validate(goodsBrandMapper);
        if (errorCode != GoodsBrandErrorCode.SUCCESS) {
            brandResponse.setId(-1l);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            GoodsBrand goodsBrand = brandRequest.toGoodsBrand();
            int insert = goodsBrandMapper.insert(goodsBrand);
            brandResponse.setId(goodsBrand.getBrandId());
        }

        response.setData(brandResponse);

        return response;
    }


    /**
     * <h2>查询</h2>
     *
     * @param createParam
     * @return
     */
    @Override
    public Response findBrand(CreateParam createParam) {
        Response response = new Response();
        if (createParam.getParam() == null) {
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            return response;
        }
        String param = createParam.getParam();
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        GoodsBrandExample.Criteria criteria = goodsBrandExample.createCriteria();
        criteria.andBrandNameLike("%" + param + "%");
        GoodsBrandExample.Criteria criteria1 = goodsBrandExample.createCriteria();
        try {
            criteria1.andBrandIdEqualTo(Long.valueOf(param));
            goodsBrandExample.or(criteria1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        List<GoodsBrand> goodsBrands = goodsBrandMapper.selectByExample(goodsBrandExample);

        response.setData(goodsBrands);
        return response;
    }

    /**
     * <h2>更新品牌信息</h2>
     *
     * @param goodsBrandRequest {@link UpdateGoodsBrandRequest 品牌VO}
     * @return
     */
    @Override
    public Response updateBrand(UpdateGoodsBrandRequest goodsBrandRequest) {
        Response response = new Response();
        GoodsBrandErrorCode errorCode = goodsBrandRequest.validate(goodsBrandMapper);
        if (errorCode != GoodsBrandErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

            return response;
        }

        GoodsBrand goodsBrand = goodsBrandRequest.toGoodsBrand();
        int i = goodsBrandMapper.updateByPrimaryKey(goodsBrand);

        response.setData(i);


        return response;
    }

    /**
     * <h2>删除品牌</h2>
     *
     * @param list {@link CreateParam 参数vo}
     * @return
     */
    @Override
    public Response delBrand(List<CreateParam> list) {
        Response response = new Response();
        if (list.size() == 0) {
            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
            return response;
        }
        int delNum = 0;

        for (CreateParam param : list) {
            try {
                int i = goodsBrandMapper.deleteByPrimaryKey(Long.valueOf(param.getParam()));
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
