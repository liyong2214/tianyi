package com.tianyi.system.vo;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Operation;

import java.util.List;

/**
 * @author : LiYong
 * @program : AuthorityBean
 * @description : 权限封装类
 * @date : 2019/9/10 11:04
 */
public class AuthorityBean extends Authority {

    // 权限拥有的操作
    private List<Operation> operationList;

    @Override
    public String toString() {
        return "AuthorityBean{ " + super.toString() +
                " operationList=" + operationList +
                '}';
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }
}
