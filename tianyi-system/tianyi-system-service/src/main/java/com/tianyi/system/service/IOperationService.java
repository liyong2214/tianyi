package com.tianyi.system.service;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Operation;

import java.util.List;

/**
 * @author : LiYong
 * @program : IOperationService
 * @description : 权限操作接口
 * @date : 2019/9/13 15:59
 */
public interface IOperationService {

    /**
     * 根据权限查询对应的权限操作
     * @param authority 权限
     * @return 操作列表
     */
    List<Operation> listOperation(Authority authority);
}
