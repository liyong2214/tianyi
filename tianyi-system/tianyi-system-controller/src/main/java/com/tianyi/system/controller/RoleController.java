package com.tianyi.system.controller;

import com.tianyi.system.log.annotation.SystemControllerLog;
import com.tianyi.system.service.IRoleService;
import com.tianyi.system.vo.RoleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : LiYong
 * @program : RoleController
 * @description : 角色
 * @date : 2019/9/15 15:03
 */
@RestController
@CrossOrigin
@RequestMapping("sys/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    // 查询角色
    @GetMapping("listRole")
    @SystemControllerLog(description = "查看角色列表")
    public ResponseEntity<List<RoleBean>> listRole() {
        return ResponseEntity.ok(roleService.listRole());
    }

    // 添加角色
    @PostMapping("saveRole")
    @SystemControllerLog(description = "添加角色")
    public String saveRole(@RequestBody RoleBean roleBean) {
        roleService.saveRole(roleBean);
        return "success";
    }

    // 修改角色
    @PutMapping("updateRole")
    @SystemControllerLog(description = "修改角色")
    public String updateRole(@RequestBody RoleBean roleBean) {
        roleService.updateRole(roleBean);
        return "success";
    }

    // 删除角色
    @DeleteMapping("deleteRole")
    @SystemControllerLog(description = "删除角色")
    public String deleteRole(int roleId) {
        roleService.removeRole(roleId);
        return "success";
    }
}
