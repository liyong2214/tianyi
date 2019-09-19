package com.tianyi.system.service;

import com.tianyi.system.vo.UserBean;
import com.tianyi.system.vo.UserRoleAuthorityBean;

import java.util.List;

/**
 * @author : LiYong
 * @program : IReportFormService
 * @description : 报表
 * @date : 2019/9/13 14:53
 */
public interface IReportFormService {

    /**
     * 权限报表
     * @return
     */
    List<UserRoleAuthorityBean> listUserForm(UserBean userBean);
}
