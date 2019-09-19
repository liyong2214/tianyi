package com.tianyi.goods.service.impl;

import com.tianyi.goods.constant.GoodsPriceProposeErrorCode;
import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.entity.GoodsPricePropose;
import com.tianyi.goods.mapper.CommodityMapper;
import com.tianyi.goods.mapper.GoodsPriceProposeMapper;
import com.tianyi.goods.service.IAdviceApproveService;
import com.tianyi.goods.service.IGoodsPriceProposeService;
import com.tianyi.goods.vo.CreateGoodsPriceProposeRequest;
import com.tianyi.goods.vo.CreateGoodsPriceProposeResponse;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tianyi
 * @description: IGoodsPriceProposeService价格申请单实现类
 * @author: Simon
 * @create: 2019-09-09 20:59
 **/
@Service
@Transactional
public class GoodsPriceProposeServiceImpl implements IGoodsPriceProposeService {


    @Autowired
    private GoodsPriceProposeMapper goodsPriceProposeMapper;

    @Autowired
    private CommodityMapper commodityMapper;


    @Autowired
    private IAdviceApproveService adviceApproveService;
//
//    @Autowired
//    private MailSender mailSender;
//
//    @Autowired
//    private SimpleMailMessage mailMessage;

    /**
     * <h2>增加价格调整申请单</h2>
     *
     * @param goodsPriceProposeRequest
     * @return {@link Response}
     */
    @Override
    public Response addGoodsPricePropose(CreateGoodsPriceProposeRequest goodsPriceProposeRequest) {
        Response response = new Response();
        CreateGoodsPriceProposeResponse goodsPriceProposeResponse = new CreateGoodsPriceProposeResponse();
        GoodsPriceProposeErrorCode errorCode = goodsPriceProposeRequest.validate(commodityMapper);
        if (errorCode != GoodsPriceProposeErrorCode.SUCCESS) {
            goodsPriceProposeResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {
            GoodsPricePropose goodsPricePropose = goodsPriceProposeRequest.toGoodsPricePropose();
            int insert = goodsPriceProposeMapper.insert(goodsPricePropose);
            goodsPriceProposeResponse.setId(goodsPricePropose.getId());
            goodsPriceProposeResponse.setApproveStage(goodsPricePropose.getApproveStage());
            goodsPriceProposeResponse.setApproveResult(goodsPricePropose.getApproveResult());
            //添加通知 todo

            adviceApproveService.advice(1, goodsPricePropose.getApproveStage());

        }

        response.setData(goodsPriceProposeResponse);
        return response;
    }

    /**
     * <h2>依据id返回价格申请单的</h2>
     *
     * @param goodsPriceProposeId {参数为：goodsPricePropose表主键id}
     * @return
     */
    @Override
    public Response getGoodsPricePropose(CreateParam goodsPriceProposeId) {
        Response response = new Response();
        ParamErrorCode errorCode = goodsPriceProposeId.validate();
        if (errorCode != ParamErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {
            String param = goodsPriceProposeId.getParam();
            GoodsPricePropose goodsPricePropose = goodsPriceProposeMapper.selectByPrimaryKey(Integer.valueOf(param));
            response.setData(goodsPricePropose);
        }
        return response;
    }
}
