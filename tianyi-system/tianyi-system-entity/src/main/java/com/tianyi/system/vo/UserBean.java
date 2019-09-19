package com.tianyi.system.vo;

import com.tianyi.system.entity.Role;
import com.tianyi.system.entity.User;

import java.util.List;

/**
 * @author : LiYong
 * @program : UserBean
 * @description : 返回用户类
 * @date : 2019/9/9 20:27
 */
public class UserBean extends User {

    // 用户拥有的角色
    private List<Role> roleList;

    // 部门名称
    private String deptName;

    // 职务名称
    private String dutyName;

    // 访问ip段
    private String ipName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getIpName() {
        return ipName;
    }

    public void setIpName(String ipName) {
        this.ipName = ipName;
    }

    @Override
    public String toString() {
        return "UserBean{" + super.toString() +
                "roleList=" + roleList +
                '}';
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
