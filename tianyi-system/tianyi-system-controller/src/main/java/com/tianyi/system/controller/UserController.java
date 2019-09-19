package com.tianyi.system.controller;

import com.tianyi.system.entity.User;
import com.tianyi.system.log.annotation.SystemControllerLog;
import com.tianyi.system.service.IUserService;
import com.tianyi.system.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : LiYong
 * @program : UserController
 * @description : 用户web层
 * @date : 2019/9/7 23:33
 */
@Controller
@CrossOrigin
@RequestMapping("sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // 查询所有用户
    @GetMapping("listUser")
    @SystemControllerLog(description = "查询所有用户")
    public ResponseEntity<List<UserBean>> listUser() {
        return ResponseEntity.ok(userService.listUser());
    }

    // 添加用户
    @PostMapping("saveUser")
    @ResponseBody
    @SystemControllerLog(description = "添加用户")
    public String saveUser(@RequestBody UserBean userBean) {
        if (userBean == null) {
            return "error";
        }
        userService.saveUser(userBean);
        return "success";
    }

    // 查询单个用户
    @GetMapping("getUser")
    @SystemControllerLog(description = "查询单个用户")
    public ResponseEntity<User> getUser(String userAccount) {
        if (userAccount == null) {
            return null;
        }
        return ResponseEntity.ok(userService.getUser(userAccount));
    }

    // 条件查询用户列表
    @PostMapping("listByCondition")
    @SystemControllerLog(description = "搜索用户列表")
    public ResponseEntity<List<UserBean>> listUserByCondition(@RequestBody UserBean userBean) {
        if (userBean == null) {
            return null;
        }
        return ResponseEntity.ok(userService.listUserByCondition(userBean));
    }

    // 修改用户
    @PutMapping("updateUser")
    @ResponseBody
    @SystemControllerLog(description = "修改用户")
    public String updateUser(@RequestBody UserBean userBean) {
        if (userBean == null) {
            return null;
        }
        userService.updateUser(userBean);
        return "success";
    }

    // 删除用户
    @DeleteMapping("removeUser")
    @ResponseBody
    @SystemControllerLog(description = "删除用户")
    public String removeUser(long userId) {
        if (userId <= 0) {
            return null;
        }
        userService.removeUser(userId);
        return "success";
    }
}
