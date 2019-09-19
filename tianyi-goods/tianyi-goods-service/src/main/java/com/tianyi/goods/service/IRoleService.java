package com.tianyi.goods.service;

import com.tianyi.goods.entity.Role;

/**
 * @program: tianyi
 * @description: 角色service
 * @author: Simon
 * @create: 2019-09-10 23:24
 **/
public interface IRoleService {

    /**
     * @param id 角色id
     * @return {@link Role}
     */
    Role findById(Integer id);
}
