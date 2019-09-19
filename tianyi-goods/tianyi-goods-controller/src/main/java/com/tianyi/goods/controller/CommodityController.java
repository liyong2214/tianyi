package com.tianyi.goods.controller;

import com.tianyi.goods.service.ICommodityService;
import com.tianyi.goods.vo.CreateCommodityRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;
import com.tianyi.goods.vo.UpdateCommodityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tianyi
 * @description: 商品conller·
 * @author: Simon
 * @create: 2019-09-11 16:23
 **/
@RestController
@RequestMapping("commodity")
public class CommodityController {


    @Autowired
    private ICommodityService commodityService;


    /**
     * <h2>添加商品</h2>
     *
     * @param commodityRequest
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("addCommodity")
    public Response addCommodity(@RequestBody CreateCommodityRequest commodityRequest) {


        return commodityService.addCommodity(commodityRequest);
    }


    /**
     * <h2>依据前端传来的name或产品号，返回对应的商品集合
     * 商品name或者id模糊查询</h2>
     *
     * @param createParam 商品名称或者id
     * @return
     */
    @ResponseBody
    @PostMapping("selectCommodityByNameOrId")
    public Response findCommodity(@RequestBody CreateParam createParam) {


        return commodityService.findCommodityByNameOrId(createParam.getParam());
    }


    /**
     * <h2>更新商品信息</h2>
     *
     * @param commodityRequest 商品请求
     * @return
     */
    @ResponseBody
    @PostMapping("updateCommodity")
    public Response updateCommodity(@RequestBody UpdateCommodityRequest commodityRequest) {

        return commodityService.updateCommodity(commodityRequest);

    }


    /**
     * <h2>批量删除商品信息</h2>
     *
     * @param list
     * @return
     */
    @ResponseBody
    @PostMapping("delCommodity")
    public Response delCommodity(@RequestBody List<CreateParam> list) {
        return commodityService.delCommodity(list);
    }

}
