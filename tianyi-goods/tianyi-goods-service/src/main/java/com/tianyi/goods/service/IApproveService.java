package com.tianyi.goods.service;

import com.tianyi.goods.vo.CreateApproveRequest;
import com.tianyi.goods.vo.CreateParam;
import com.tianyi.goods.vo.Response;

/**
 * @program: tianyi
 * @description: 审批提交
 * @author: Simon
 * @create: 2019-09-15 11:39
 **/
public interface IApproveService {


    /**
     * <h2>添加审批</h2>
     *
     * @param approveRequest {@link CreateApproveRequest}
     * @return
     */
    Response addApprove(CreateApproveRequest approveRequest);


    /**
     * @param approveid {参数}
     * @return
     */
    Response getApprove(CreateParam approveid);


    /**
     * <h2>根据申请表id获得所有的审批单</h2>
     * @param proposeId
     * @return
     */
    Response getApproveByProposeId(Integer proposeId,Integer proposeType);

}
