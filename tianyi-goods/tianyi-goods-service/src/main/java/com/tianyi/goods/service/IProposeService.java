package com.tianyi.goods.service;

import com.tianyi.goods.vo.Response;

/**
 * @program: tianyi
 * @description: 申请单service
 * @author: Simon
 * @create: 2019-09-15 17:02
 **/
public interface IProposeService {


    /**
     * {依据前台传入的用户id，返回该用户下所有的有权限审批的申请单}
     *
     * @param userId {用户id}
     * @return
     */
    Response getAllPropose(Long userId);


}
