package com.tianyi.goods.controller;

import com.tianyi.goods.service.*;
import com.tianyi.goods.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: tianyi
 * @description: 各种关于商品，活动、赠品申请
 * @author: Simon
 * @create: 2019-09-12 16:56
 **/
@RestController
@RequestMapping("application")
public class ApplicationController {

    @Autowired
    private IGoodsPriceProposeService goodsPriceProposeService;

    @Autowired
    private ICommodityPromotionProposeService commodityPromotionProposeService;


    @Autowired
    private ITransformService transformService;

    @Autowired
    private IApproveService approveService;

    @Autowired
    private IProposeService proposeService;

    /**
     * <h2>生成商品价格修改申请单</h2>
     *
     * @param goodsPriceProposeRequest {@link CreateGoodsPriceProposeRequest}
     * @return
     */
    @ResponseBody
    @PostMapping("commodityPriceApplication")
    public Response addCommodityPriceApplication(@RequestBody CreateGoodsPriceProposeRequest goodsPriceProposeRequest) {

        return goodsPriceProposeService.addGoodsPricePropose(goodsPriceProposeRequest);
    }


    /**
     * <h2>商品促销活动申请单</h2>
     *
     * @param commodityPromotionProposeRequest
     * @return
     */
    @ResponseBody
    @PostMapping("commodityPromotionPropose")
    public Response addCommodityPromotionPropose(@RequestBody CreateCommodityPromotionProposeRequest commodityPromotionProposeRequest) {
        System.out.println("进入了");
        return commodityPromotionProposeService.addCommodityPromotionPropose(commodityPromotionProposeRequest);
    }

    /**
     * <h2>商品转赠品申请单</h2>
     *
     * @param transformGoodsComplimentaryRequest {@link CreateTransformGoodsComplimentaryRequest}
     * @return
     */
    @ResponseBody
    @PostMapping("goodsToComplimentaryPropose")
    public Response addTransformToComplimentary(@RequestBody CreateTransformGoodsComplimentaryRequest transformGoodsComplimentaryRequest) {
        //           设置申请单类别
        transformGoodsComplimentaryRequest.setProposeType(3);
        return transformService.transformPropose(transformGoodsComplimentaryRequest);
    }

    /**
     * <h2>赠品转商品申请单</h2>
     *
     * @param transformGoodsComplimentaryRequest {@link CreateTransformGoodsComplimentaryRequest}
     * @return
     */
    @ResponseBody
    @PostMapping("complimentaryToGoodsPropose")
    public Response addTransformToGoods(@RequestBody CreateTransformGoodsComplimentaryRequest transformGoodsComplimentaryRequest) {
//           设置申请单类别
        transformGoodsComplimentaryRequest.setProposeType(4);
        return transformService.transformPropose(transformGoodsComplimentaryRequest);
    }


    /**
     * <h2>审查表添加</h2>
     *
     * @param approveRequest
     * @return
     */
    @ResponseBody
    @PostMapping("addApprove")
    public Response approve(@RequestBody CreateApproveRequest approveRequest) {
        return approveService.addApprove(approveRequest);
    }


    /**
     * <h2>获得价格修改申请表</h2>
     *
     * @return
     */
    @ResponseBody
    @PostMapping("getGoodsPricePropose")
    public Response getGoodsPricePropose(@RequestBody CreateParam createParam) {

        return goodsPriceProposeService.getGoodsPricePropose(createParam);

    }


    /**
     * <h2>获得商品促销申请表</h2>
     *
     * @param id {申请表的id}
     * @return
     */
    @ResponseBody
    @GetMapping("getCommodityPromotionPropose/{id}")
    public Response getCommodityPromotionPropose(@PathVariable("id") Integer id) {

        return commodityPromotionProposeService.getCommodityPromotionPropose(id);

    }

    /**
     * <h2>依据用户id，返回其有权限审批的所有单据</h2>
     *
     * @param userId {用户id}
     * @return
     */
    @ResponseBody
    @GetMapping("getAllProposeByUserId/{userId}")
    public Response getAllProposeByUserId(@PathVariable("userId") Long userId) {
        System.out.println(userId);
        return proposeService.getAllPropose(userId);
    }
}
