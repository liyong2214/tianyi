package com.tianyi.goods.service;

import com.tianyi.goods.entity.User;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/**
 * @program: tianyi
 * @description: UesrService类
 * @author: Simon
 * @create: 2019-09-10 20:20
 **/
public interface IUserService {


    /**
     * @param account  账号
     * @param password 密码
     * @return {@link User}
     */
    User selectUserByAccount(String account, String password);


    /**
     * @param userId {用户id }
     * @return {@link User}
     */
    User selectUserByUserId(Long userId);
}
