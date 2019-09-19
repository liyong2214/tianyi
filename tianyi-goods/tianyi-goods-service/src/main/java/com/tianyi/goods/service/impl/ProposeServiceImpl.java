package com.tianyi.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.tianyi.goods.entity.*;
import com.tianyi.goods.mapper.CommodityPromotionProposeMapper;
import com.tianyi.goods.mapper.GoodsPriceProposeMapper;
import com.tianyi.goods.mapper.ProposeStateAuthorityMapper;
import com.tianyi.goods.mapper.TransformGoodsComplimentaryMapper;
import com.tianyi.goods.service.*;
import com.tianyi.goods.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * @program: tianyi
 * @description: IProposeService的实现类
 * @author: Simon
 * @create: 2019-09-15 17:04
 **/
@Service
@Transactional
public class ProposeServiceImpl implements IProposeService {

    @Autowired
    private IGoodsPriceProposeService goodsPriceProposeService;


    @Autowired
    private ICommodityPromotionProposeService commodityPromotionProposeService;


    @Autowired
    private ITransformService transformService;


    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleServicel;

    @Autowired
    private IRoleAuthorityService roleAuthorityService;

    @Autowired
    private ProposeStateAuthorityMapper proposeStateAuthorityMapper;

    @Autowired
    private GoodsPriceProposeMapper goodsPriceProposeMapper;

    @Autowired
    private TransformGoodsComplimentaryMapper transformGoodsComplimentaryMapper;

    @Autowired
    private CommodityPromotionProposeMapper commodityPromotionProposeMapper;

    /**
     *<h2>根据用户id查询其名下的所能审批的所有申请单</h2>
     * @param userId {用户id}
     * @return
     */
    @Override
    public Response getAllPropose(Long userId) {
        Response response = new Response();
        User user = userService.selectUserByUserId(userId);
        if (user.getUserAccount() == null) {

            return response;
        }
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        String data = jedis.get(userId + "proposeStateAuthoritySet");
        //审批阶段权限表set
        Set<ProposeStateAuthority> proposeStateAuthoritySet = new HashSet<>();
        //如果redis中没有，就从数据库取
        if (StringUtils.isEmpty(data)) {
            System.out.println("数据库查询");
            Set<Integer> rolesId = userRoleServicel.findRolesByUserId(userId);

            for (Integer rid : rolesId) {
                Set<Integer> authorithIds = roleAuthorityService.findAuthorithByRoleId(rid);
                //根据权限id，划定可以审批的表格
                for (Integer id : authorithIds) {
                    ProposeStateAuthorityExample proposeStateAuthorityExample = new ProposeStateAuthorityExample();
                    ProposeStateAuthorityExample.Criteria criteria = proposeStateAuthorityExample.createCriteria();
                    criteria.andAuthorityIdEqualTo(id);

                    List<ProposeStateAuthority> proposeStateAuthorities = proposeStateAuthorityMapper.selectByExample(proposeStateAuthorityExample);

                    System.out.println(proposeStateAuthorities);
                    proposeStateAuthoritySet.addAll(proposeStateAuthorities);
                }

            }
            String jsonString = JSON.toJSONString(proposeStateAuthoritySet);
            jedis.setex(userId + "proposeStateAuthoritySet", 60 * 15, jsonString);
        } else {
            System.out.println("redis查询");
            //如果redis中有，从redis中解析
            List<ProposeStateAuthority> proposeStateAuthorities = JSON.parseArray(data, ProposeStateAuthority.class);
            proposeStateAuthoritySet.addAll(proposeStateAuthorities);
        }


        List<GoodsPricePropose> goodsPriceProposeList = new ArrayList<>();
        List<CommodityPromotionPropose> commodityPromotionProposeList = new ArrayList<>();
        List<TransformGoodsComplimentary> transformGoodsComplimentaryList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        //依据proposeStateAuthority的条件进行查询符合条件的申请单
        for (ProposeStateAuthority proposeStateAuthority : proposeStateAuthoritySet) {
            if (proposeStateAuthority.getProposeType() == 1) {
                //价格修改单
                GoodsPriceProposeExample goodsPriceProposeExample = new GoodsPriceProposeExample();
                GoodsPriceProposeExample.Criteria criteria = goodsPriceProposeExample.createCriteria();
                criteria.andApproveStageEqualTo(proposeStateAuthority.getApproveState());
                List<GoodsPricePropose> goodsPriceProposes = goodsPriceProposeMapper.selectByExample(goodsPriceProposeExample);
                goodsPriceProposeList.addAll(goodsPriceProposes);

            } else if (proposeStateAuthority.getProposeType() == 2) {
                //促销单
                CommodityPromotionProposeExample commodityPromotionProposeExample = new CommodityPromotionProposeExample();
                CommodityPromotionProposeExample.Criteria criteria = commodityPromotionProposeExample.createCriteria();
                criteria.andApproveStageEqualTo(proposeStateAuthority.getApproveState());

                List<CommodityPromotionPropose> commodityPromotionProposes = commodityPromotionProposeMapper.selectByExample(commodityPromotionProposeExample);
                commodityPromotionProposeList.addAll(commodityPromotionProposes);

            } else if (proposeStateAuthority.getProposeType() == 3 || proposeStateAuthority.getProposeType() == 4) {
                //赠品商品转换申请单
                TransformGoodsComplimentaryExample transformGoodsComplimentaryExample = new TransformGoodsComplimentaryExample();
                TransformGoodsComplimentaryExample.Criteria criteria = transformGoodsComplimentaryExample.createCriteria();
                criteria.andApproveStateEqualTo(proposeStateAuthority.getApproveState());

                List<TransformGoodsComplimentary> transformGoodsComplimentaries = transformGoodsComplimentaryMapper.selectByExample(transformGoodsComplimentaryExample);

                transformGoodsComplimentaryList.addAll(transformGoodsComplimentaries);

            }

        }

        map.put("goodsPriceProposeList", goodsPriceProposeList);
        map.put("commodityPromotionProposeList", commodityPromotionProposeList);
        map.put("transformGoodsComplimentaryList", transformGoodsComplimentaryList);

        response.setData(map);


        return response;
    }
}
