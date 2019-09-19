package com.tianyi.goods.service;

import com.tianyi.goods.entity.Authority;

import java.util.Set;

/**
 * @program: tianyi
 * @description: 权限service
 * @author: Simon
 * @create: 2019-09-10 23:33
 **/
public interface IAuthorityService {


    /**
     * @param id 权限id
     * @return 权限实体类
     */
    Authority findById(Integer id);
}
