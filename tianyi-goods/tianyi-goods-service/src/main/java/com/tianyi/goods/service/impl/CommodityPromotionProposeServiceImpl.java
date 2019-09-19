package com.tianyi.goods.service.impl;

import com.tianyi.goods.constant.CommodityPromotionProposeErrorCode;
import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.entity.CommodityPromotionPropose;
import com.tianyi.goods.mapper.CommodityMapper;
import com.tianyi.goods.mapper.CommodityPromotionProposeMapper;
import com.tianyi.goods.service.IAdviceApproveService;
import com.tianyi.goods.service.ICommodityPromotionProposeService;
import com.tianyi.goods.vo.CreateCommodityPromotionProposeRequest;
import com.tianyi.goods.vo.CreateCommodityPromotionProposeResponse;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tianyi
 * @description: ICommodityPromotionPropose的实现类，生成促销价格申请单
 * @author: Simon
 * @create: 2019-09-14 10:56
 **/
@Service
@Transactional
public class CommodityPromotionProposeServiceImpl implements ICommodityPromotionProposeService {


    @Autowired
    private CommodityPromotionProposeMapper commodityPromotionProposeMapper;


    @Autowired
    private CommodityMapper commodityMapper;


    @Autowired
    private IAdviceApproveService adviceApproveService;

    /**
     * <h2>生成商品价格促销申请单</h2>
     *
     * @param commodityPromotionProposeRequest {@link CreateCommodityPromotionProposeRequest 商品价格促销申请单VO}
     * @return
     */
    @Override
    public Response addCommodityPromotionPropose(CreateCommodityPromotionProposeRequest commodityPromotionProposeRequest) {
        Response response = new Response();
        CommodityPromotionProposeErrorCode errorCode = commodityPromotionProposeRequest.validate(commodityMapper);
        CreateCommodityPromotionProposeResponse commodityPromotionProposeResponse = new CreateCommodityPromotionProposeResponse();
        if (errorCode != CommodityPromotionProposeErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {
            CommodityPromotionPropose commodityPromotionPropose = commodityPromotionProposeRequest.toCommodityPromotionPropose();
            int insert = commodityPromotionProposeMapper.insert(commodityPromotionPropose);
            commodityPromotionProposeResponse.setId(commodityPromotionPropose.getId());
            commodityPromotionProposeResponse.setApproveStage(commodityPromotionPropose.getApproveStage());
            commodityPromotionProposeResponse.setApproveResult(commodityPromotionPropose.getApproveResult());
            response.setData(commodityPromotionProposeResponse);

            //通知 todo
            adviceApproveService.advice(2, commodityPromotionPropose.getApproveStage());
        }


        return response;
    }

    /**
     * <h2>  依据主键id，返回对应的CommodityPromotionPropose表</h2>
     *
     * @param commodityPromotionProposeId {@link CreateParam  存值为CommodityPromotionProposeId表的主键id}
     * @return
     */
    @Override
    public Response getCommodityPromotionPropose(Integer commodityPromotionProposeId) {
        Response response = new Response();

        if (commodityPromotionProposeId == null) {
            response.setErrorCode(ParamErrorCode.EMPTY_PARAM.getCode());
            response.setErrorMsg(ParamErrorCode.EMPTY_PARAM.getDesc());
        } else {

            CommodityPromotionPropose commodityPromotionPropose = commodityPromotionProposeMapper.selectByPrimaryKey(commodityPromotionProposeId);

            response.setData(commodityPromotionPropose);


        }


        return response;
    }
}
