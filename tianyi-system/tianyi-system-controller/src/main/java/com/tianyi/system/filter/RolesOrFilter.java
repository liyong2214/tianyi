package com.tianyi.system.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author : LiYong
 * @program : RolesOrFilter
 * @description : 自定义过滤器
 * @date : 2019/9/11 21:10
 */
public class RolesOrFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        // 获取主体
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] roles = (String[]) o;

        if (roles == null || roles.length == 0) {
            return false;
        }
        for (String role : roles) {
            if (subject.hasRole(role))  {
                return true;  // 如果有某个角色，直接返回true
            }
        }
        return false;
    }
}
