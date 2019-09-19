package com.tianyi.system.service.impl;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.AuthorityOperationExample;
import com.tianyi.system.entity.AuthorityOperationKey;
import com.tianyi.system.entity.Operation;
import com.tianyi.system.mapper.AuthorityOperationMapper;
import com.tianyi.system.mapper.OperationMapper;
import com.tianyi.system.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiYong
 * @program : OperationServiceImpl
 * @description : 权限操作实现类
 * @date : 2019/9/13 16:01
 */
@Service
@Transactional
public class OperationServiceImpl implements IOperationService {

    @Autowired
    private OperationMapper operationMapper;

    @Autowired
    private AuthorityOperationMapper authorityOperationMapper;
    /**
     * 根据权限查询对应的权限操作
     *
     * @param authority 权限
     * @return 操作列表
     */
    @Override
    public List<Operation> listOperation(Authority authority) {
        // 查询权限对应的操作id
        AuthorityOperationExample authorityOperationExample = new AuthorityOperationExample();
        AuthorityOperationExample.Criteria criteria = authorityOperationExample.createCriteria();
        criteria.andAuthorityIdEqualTo(authority.getAuthorityId());
        List<AuthorityOperationKey> authorityOperationKeyList = authorityOperationMapper.selectByExample(authorityOperationExample);

        // 通过id查询所有的操作信息
        List<Operation> operationList = new ArrayList<>();
        for (AuthorityOperationKey authorityOperationKey : authorityOperationKeyList) {
            Operation operation = operationMapper.selectByPrimaryKey(authorityOperationKey.getOperationId());
            operationList.add(operation);
        }
        return operationList;
    }
}
