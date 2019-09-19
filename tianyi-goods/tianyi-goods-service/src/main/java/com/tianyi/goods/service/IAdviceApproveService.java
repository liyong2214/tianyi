package com.tianyi.goods.service;

import com.tianyi.goods.entity.ProposeStateAuthority;

import java.util.List;

/**
 * @program: tianyi
 * @description: 通知审批接口
 * @author: Simon
 * @create: 2019-09-11 11:42
 **/
public interface IAdviceApproveService {


    /**
     * @param authorityId {权限id}
     */
    void adviceByauthorityId(Integer authorityId);


    /**
     * @param proposeTypeId {申请表类型id}
     * @param approveState  {申请阶段}
     * @return {@link ProposeStateAuthority  申请阶段权限限定表  }
     */
    List<ProposeStateAuthority> getApproveAuthority(Integer proposeTypeId, Integer approveState);


    /**
     * @param proposeTypeId {申请表类型id}
     * @param approveState  {申请阶段}
     */
    void advice(Integer proposeTypeId, Integer approveState);
}
