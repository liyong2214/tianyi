package com.tianyi.goods.service.impl;

import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.constant.TransformGoodsComplimentaryErrorCode;
import com.tianyi.goods.entity.TransformGoodsComplimentary;
import com.tianyi.goods.mapper.GoodsMapper;
import com.tianyi.goods.mapper.TransformGoodsComplimentaryMapper;
import com.tianyi.goods.service.ITransformService;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.CreateTransformGoodsComplimentaryRequest;
import com.tianyi.goods.vo.CreateTransformGoodsComplimentaryResponse;
import com.tianyi.goods.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tianyi
 * @description: ITransformService实现类
 * @author: Simon
 * @create: 2019-09-14 17:19
 **/
@Service
@Transactional
public class TransformServiceImpl implements ITransformService {

    @Autowired
    private TransformGoodsComplimentaryMapper transformGoodsComplimentaryMapper;

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * <h2>赠品与商品间的转换申请单</h2>
     *
     * @param transformGoodsComplimentaryRequest
     * @return
     */
    @Override
    public Response transformPropose(CreateTransformGoodsComplimentaryRequest transformGoodsComplimentaryRequest) {
        Response response = new Response();
        TransformGoodsComplimentaryErrorCode errorCode = transformGoodsComplimentaryRequest.valiDate(goodsMapper);
        CreateTransformGoodsComplimentaryResponse transformGoodsComplimentaryResponse = new CreateTransformGoodsComplimentaryResponse();
        if (errorCode != TransformGoodsComplimentaryErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
            transformGoodsComplimentaryResponse.setId(-1);

        } else {
            TransformGoodsComplimentary transformGoodsComplimentary = transformGoodsComplimentaryRequest.toTransformGoodsComplimentary();
            int insert = transformGoodsComplimentaryMapper.insert(transformGoodsComplimentary);
            transformGoodsComplimentaryResponse.setId(transformGoodsComplimentary.getId());
            //todo 通知
        }


        response.setData(transformGoodsComplimentaryResponse);

        return response;
    }

    /**
     * <h2>依据转换申请单的id，返回特定的申请单</h2>
     *
     * @param transFormProposeId { 转换申请单的id}
     * @return
     */
    @Override
    public Response getTransFormPropose(CreateParam transFormProposeId) {
        Response response = new Response();
        ParamErrorCode errorCode = transFormProposeId.validate();

        if (errorCode != ParamErrorCode.SUCCESS) {
            response.setErrorMsg(errorCode.getDesc());
            response.setErrorCode(errorCode.getCode());

        } else {
            String param = transFormProposeId.getParam();
            TransformGoodsComplimentary transformGoodsComplimentary = transformGoodsComplimentaryMapper.selectByPrimaryKey(Integer.valueOf(param));
            response.setData(transformGoodsComplimentary);
        }

        return response;
    }
}
