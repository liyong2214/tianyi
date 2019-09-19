package com.tianyi.system.controller;

import com.tianyi.system.entity.User;
import com.tianyi.system.enumModule.StatusMessageEnum;
import com.tianyi.system.exception.MyException;
import com.tianyi.system.util.OJsonUtil;
import com.tianyi.system.vo.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author : LiYong
 * @program : HomeController
 * @description : 登陆注册管理
 * @date : 2019/9/11 16:58
 */
@RestController
@CrossOrigin
public class HomeController {

    @PostMapping(value = "doLogin")
    public String doLogin(UserBean user,HttpSession session) {

        // 放入session
        if (user == null) {
            throw new MyException(StatusMessageEnum.NUll_PARAM);
        }

        // shiro验证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(), user.getUserPassword());

        try {
//            token.setRememberMe(true);
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        // 判断是否有相应的角色
        if (subject.hasRole("销售")) {
            return "有‘销售’的角色";
        }
        if (subject.hasRole("采购")) {
            return "有 采购 的角色";
        }

        return "登录成功";
    }

    @RequiresRoles("采购员")
    @GetMapping("testRole")
    public String testRole() {
        return "test role success";
    }

}
