package com.tianyi.system.vo;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Department;
import com.tianyi.system.entity.Role;

import java.util.List;

/**
 * @author : LiYong
 * @program : RoleBean
 * @description : 角色返回实体类
 * @date : 2019/9/8 21:47
 */

public class RoleBean extends Role {

    private List<Authority> authorityList;  // 角色权限

    private List<Department> departmentList;  // 角色部门

    @Override
    public String toString() {
        return "RoleBean{ " + super.toString() +
                " authorityList=" + authorityList +
                ", departmentList=" + departmentList +
                '}';
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
