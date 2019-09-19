package com.tianyi.system.filter;

import com.tianyi.system.entity.User;
import com.tianyi.system.service.IUserService;
import jdk.nashorn.internal.runtime.GlobalConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : LiYong
 * @program : UserSessionFilter
 * @description : 用户信息session
 * @date : 2019/9/16 0:30
 */
public class UserSessionFilter extends AccessControlFilter {

    @Autowired
    private IUserService userService;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("会话session执行");
        Subject subject = getSubject(request, response);
        if (subject == null) {
            // 没有登录
            return false;
        }
        HttpSession session = WebUtils.toHttp(request).getSession();
        Object sessionUserName = session.getAttribute("currentUser");
        if (sessionUserName == null) {
            // 去数据库查询
            String userAccount = (String) SecurityUtils.getSubject().getPrincipal();
            User user = userService.getUser(userAccount);
            session.setAttribute("currentUser", user);
        }
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return true;
    }
}
