package com.tianyi.goods.service.impl;

import com.tianyi.goods.constant.ApproveErrorCode;
import com.tianyi.goods.constant.ParamErrorCode;
import com.tianyi.goods.entity.*;
import com.tianyi.goods.mapper.*;
import com.tianyi.goods.service.IApproveService;
import com.tianyi.goods.service.IUserService;
import com.tianyi.goods.service.realm.AuthRealm;
import com.tianyi.goods.vo.CreateApproveRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tianyi
 * @description: IApproveService的实现类
 * @author: Simon
 * @create: 2019-09-15 11:43
 **/
@Service
@Transactional
public class ApproveServiceImpl implements IApproveService {

    @Autowired
    private ApproveMapper approveMapper;


    @Autowired
    private GoodsPriceProposeMapper goodsPriceProposeMapper;

    @Autowired
    private CommodityPromotionProposeMapper commodityPromotionProposeMapper;

    @Autowired
    private TransformGoodsComplimentaryMapper transformGoodsComplimentaryMapper;

    @Autowired
    private AuthRealm authRealm;

    @Autowired
    private IUserService userService;


    @Autowired
    private ProposeStateAuthorityMapper proposeStateAuthorityMapper;


    @Autowired
    private ProposeApproveMapper proposeApproveMapperl;

    /**
     * <h2>添加审批</h2>
     *
     * @param approveRequest {@link CreateApproveRequest}
     * @return
     */
    @Override
    public Response addApprove(CreateApproveRequest approveRequest) {
        Response response = new Response();


        ApproveErrorCode errorCode = approveRequest.validate();
        if (errorCode != ApproveErrorCode.SUCCESS) {

            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {


            Approve approve = approveRequest.toApprove();
            approveMapper.insert(approve);

            //插入ProposeApprove
            ProposeApprove proposeApprove = new ProposeApprove();
            proposeApprove.setApproveId(approve.getId());
            proposeApprove.setProposeId(approve.getProposeId());
            proposeApprove.setProposeType(approve.getProposeType());

            proposeApproveMapperl.insert(proposeApprove);

            response.setData(approve.getId());


            //修改对应申请单的状态
            //查询对应的申请单
            if (approve.getProposeType() == 1) {
                //价格修改单
                GoodsPricePropose goodsPricePropose = goodsPriceProposeMapper.selectByPrimaryKey(approve.getProposeId());
                Integer approveResult = approve.getApproveResult();
                if (approveResult == 0) {
                    goodsPricePropose.setApproveStage(0);
                    goodsPricePropose.setApproveResult(false);
                } else if (approveResult == 1) {
                    goodsPricePropose.setApproveStage(goodsPricePropose.getApproveStage() + 1);
                    goodsPricePropose.setApproveResult(false);
                } else if (approveResult == 2) {
                    goodsPricePropose.setApproveStage(0);
                    goodsPricePropose.setApproveResult(true);
                }
                //数据库更新
                goodsPriceProposeMapper.updateByPrimaryKey(goodsPricePropose);


            } else if (approve.getProposeType() == 2) {
                //促销单
                CommodityPromotionPropose commodityPromotionPropose = commodityPromotionProposeMapper.selectByPrimaryKey(approve.getProposeId());
                Integer approveResult = approve.getApproveResult();
                if (approveResult == 0) {
                    commodityPromotionPropose.setApproveStage(0);
                    commodityPromotionPropose.setApproveResult(false);
                } else if (approveResult == 1) {
                    commodityPromotionPropose.setApproveStage(commodityPromotionPropose.getApproveStage() + 1);
                    commodityPromotionPropose.setApproveResult(false);
                } else if (approveResult == 2) {
                    commodityPromotionPropose.setApproveStage(0);
                    commodityPromotionPropose.setApproveResult(true);
                }
                //数据库更新
                commodityPromotionProposeMapper.updateByPrimaryKey(commodityPromotionPropose);

            } else if (approve.getProposeType() == 3 || approve.getProposeType() == 4) {
                //赠品商品转换申请单
                TransformGoodsComplimentary transformGoodsComplimentary = transformGoodsComplimentaryMapper.selectByPrimaryKey(approve.getProposeId());

                Integer approveResult = approve.getApproveResult();
                if (approveResult == 0) {
                    transformGoodsComplimentary.setApproveState(0);
                    transformGoodsComplimentary.setApproveResult(false);
                } else if (approveResult == 1) {
                    transformGoodsComplimentary.setApproveState(transformGoodsComplimentary.getApproveState() + 1);
                    transformGoodsComplimentary.setApproveResult(false);
                } else if (approveResult == 2) {
                    transformGoodsComplimentary.setApproveState(0);
                    transformGoodsComplimentary.setApproveResult(true);
                }
                //数据库更新
                transformGoodsComplimentaryMapper.updateByPrimaryKey(transformGoodsComplimentary);

            }
            //修改申请单

        }

        return response;
    }


    /**
     * @param createParam {传入申请id参数}
     * @return
     */
    @Override
    public Response getApprove(CreateParam createParam) {
        Response response = new Response();
        ParamErrorCode errorCode = createParam.validate();

        if (errorCode != ParamErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());

        } else {
            String param = createParam.getParam();
            Approve approve = approveMapper.selectByPrimaryKey(Long.valueOf(param));
            response.setData(approve);

        }


        return response;
    }

    /**
     * @param proposeId
     * @param proposeType
     * @return
     */
    @Override
    public Response getApproveByProposeId(Integer proposeId, Integer proposeType) {
        return null;
    }
}
