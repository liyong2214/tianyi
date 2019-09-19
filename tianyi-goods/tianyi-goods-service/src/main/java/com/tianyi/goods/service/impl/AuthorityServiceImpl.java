package com.tianyi.goods.service.impl;

import com.tianyi.goods.entity.Authority;
import com.tianyi.goods.mapper.AuthorityMapper;
import com.tianyi.goods.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tianyi
 * @description:
 * @author: Simon
 * @create: 2019-09-10 23:36
 **/
@Service
@Transactional
public class AuthorityServiceImpl implements IAuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;


    /**
     * @param id 权限id
     * @return
     */
    @Override
    public Authority findById(Integer id) {
        if (id == null) {
            return null;
        }

        Authority authority = authorityMapper.selectByPrimaryKey(id);

        return authority;
    }
}
