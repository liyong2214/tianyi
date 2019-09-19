package com.tianyi.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.tianyi.goods.entity.ProposeStateAuthority;
import com.tianyi.goods.entity.ProposeStateAuthorityExample;
import com.tianyi.goods.entity.Role;
import com.tianyi.goods.entity.User;
import com.tianyi.goods.mapper.ProposeStateAuthorityMapper;
import com.tianyi.goods.service.*;
import com.tianyi.goods.service.utils.ApproveEmailAdviceUtil;
import com.tianyi.goods.vo.CreateApproveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: tianyi
 * @description: 审批通知实现类
 * @author: Simon
 * @create: 2019-09-13 10:52
 **/
@Service
@Transactional
public class AdviceApproveServiceImpl implements IAdviceApproveService {


    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleAuthorityService roleAuthorityService;


    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserService userService;


    @Autowired
    private ProposeStateAuthorityMapper stateAuthorityMapper;


    @Autowired
    private ApproveEmailAdviceUtil emailAdviceUtil;

    /**
     * <h2>给拥有对应权限的用户发送邮件</h2>
     *
     * @param authorityId {权限id}
     */
    @Override
    public void adviceByauthorityId(Integer authorityId) {


        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        String data = jedis.get("adviceByauthorityId" + authorityId);
        if (StringUtils.isEmpty(data)) {

            //1、查询出拥有审批权限的角色
            Set<Role> roleByAuthority = roleAuthorityService.findRoleByAuthority(authorityId);


            Set<User> userSet = new HashSet<>();
            //2、查询出拥有审批权限角色下的用户
            for (Role role : roleByAuthority) {
                Set<User> usersByRoleId = userRoleService.findUsersByRoleId(role.getRoleId());
                userSet.addAll(usersByRoleId);
                emailAdviceUtil.sendMail(usersByRoleId);

            }

            String jsonString = JSON.toJSONString(userSet);
            jedis.set("adviceByauthorityId" + authorityId, jsonString);
            jedis.close();

        } else {
            List<User> users = JSON.parseArray(data, User.class);
            Set<User> userSet = new HashSet<>();
            userSet.addAll(users);
            emailAdviceUtil.sendMail(userSet);
            jedis.close();
        }


    }

    /***
     *
     * <h2>依据申请表类型id和申请阶段，返回申请阶段对应权限表</h2>
     * @param proposeTypeId {申请表类型id}
     * @param approveState  {申请阶段}
     * @return
     */

    @Override
    public List<ProposeStateAuthority> getApproveAuthority(Integer proposeTypeId, Integer approveState) {
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        String data = jedis.get(String.valueOf(proposeTypeId + approveState));
        if (StringUtils.isEmpty(data)) {
            ProposeStateAuthorityExample proposeStateAuthorityExample = new ProposeStateAuthorityExample();
            ProposeStateAuthorityExample.Criteria criteria = proposeStateAuthorityExample.createCriteria();
            criteria.andProposeTypeEqualTo(proposeTypeId);
            criteria.andApproveStateEqualTo(approveState);
            List<ProposeStateAuthority> proposeStateAuthorities = stateAuthorityMapper.selectByExample(proposeStateAuthorityExample);
            //将数据存入redis
            String jsonString = JSON.toJSONString(proposeStateAuthorities);
            jedis.set(String.valueOf(proposeTypeId + approveState), jsonString);
            return proposeStateAuthorities;
        } else {
            //从redis中获取数据
            List<ProposeStateAuthority> proposeStateAuthorities = JSON.parseArray(data, ProposeStateAuthority.class);
            return proposeStateAuthorities;
        }


    }

    /***
     *<h2>依据申请表类型id和申请阶段，给对应的人发送通知</h2>
     * @param proposeTypeId {申请表类型id}
     * @param approveState  {申请阶段}
     */
    @Override
    public void advice(Integer proposeTypeId, Integer approveState) {
        List<ProposeStateAuthority> approveAuthority = getApproveAuthority(proposeTypeId, approveState);
        for (ProposeStateAuthority proposeStateAuthority : approveAuthority) {
            adviceByauthorityId(proposeStateAuthority.getAuthorityId());
        }
    }





}
