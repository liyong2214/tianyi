package com.tianyi.system.controller;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Operation;
import com.tianyi.system.entity.Role;
import com.tianyi.system.log.annotation.SystemControllerLog;
import com.tianyi.system.service.IAuthorityService;
import com.tianyi.system.service.IReportFormService;
import com.tianyi.system.util.JedisUtil;
import com.tianyi.system.util.OJsonUtil;
import com.tianyi.system.vo.AuthorityBean;
import com.tianyi.system.vo.UserBean;
import com.tianyi.system.vo.UserRoleAuthorityBean;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author : LiYong
 * @program : AuthorityController
 * @description : 权限controller
 * @date : 2019/9/13 16:41
 */
@RestController
@CrossOrigin
@RequestMapping("sys/authority")
public class AuthorityController {

    @Autowired
    private IReportFormService reportFormService;

    @Autowired
    private IAuthorityService authorityService;

    @Autowired
    private JedisUtil jedisUtil;

    @GetMapping("listAuthority")
    @SystemControllerLog(description = "查看权限列表")
    public ResponseEntity<List<AuthorityBean>> listAuthority() {
        return ResponseEntity.ok(authorityService.listAuthority());
    }

    @PostMapping("saveAuthority")
    @SystemControllerLog(description = "添加权限")
    public String saveAuthority(@RequestBody AuthorityBean authorityBean) {
        authorityService.saveAuthority(authorityBean);
        return "success";
    }

    @PutMapping("updateAuthority")
    @SystemControllerLog(description = "修改权限")
    public String updateAuthority(@RequestBody AuthorityBean authorityBean) {
        authorityService.updateAuthority(authorityBean);
        return "success";
    }

    @DeleteMapping("deleteAuthority")
    @SystemControllerLog(description = "删除权限")
    public String deleteAuthority(int authorityId) {
        authorityService.deleteAuthority(authorityId);
        return "success";
    }

    /**
     * 获取权限报表数据
     * @param userBean 查询条件
     * @return list
     */
    @PostMapping("getAuthorityForm")
    @SystemControllerLog(description = "查询权限报表")
    public ResponseEntity<List<UserRoleAuthorityBean>> getAuthorityForm(@RequestBody UserBean userBean) {
        List<UserRoleAuthorityBean> authorityForm = getListResponseEntity(userBean);
        return ResponseEntity.ok(authorityForm);
    }

    private List<UserRoleAuthorityBean> getListResponseEntity(UserBean userBean) {
        String authorityForm = jedisUtil.get("authorityForm", 2);
        if (StringUtils.isEmpty(authorityForm)) {
            System.out.println("从数据库中查询权限报表数据");
            // 去数据库查询
            List<UserRoleAuthorityBean> list = reportFormService.listUserForm(userBean);
            // 将数据转换为字符串
            String data = OJsonUtil.toString(list);
            // 放入redis
            jedisUtil.set("authorityForm",data,2);
            // 返回数据
            return list;
        } else {
            // 转换为对象
            System.out.println("从缓存中读取权限报表数据");
            // 返回数据
            return OJsonUtil.toList(authorityForm, UserRoleAuthorityBean.class);
        }
    }


    /**
     * 导出权限报表
     * @param userBean 条件
     * @param response 相应
     * @throws IOException 异常
     */
    @PostMapping("downLoadAuthorityForm")
    @SystemControllerLog(description = "导出权限报表")
    public void downLoadAuthorityForm(@RequestBody UserBean userBean, HttpServletResponse response) throws IOException {
        List<UserRoleAuthorityBean> list = getListResponseEntity(userBean);
        System.out.println(list);

        // 创建工作薄
        Workbook workbook = new XSSFWorkbook();
        // 创建页
        Sheet sheet = workbook.createSheet("权限报表");

        // 样式
        CellStyle cellStyle = workbook.createCellStyle();
        // 边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 文字水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 文字垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 字体
        Font font = workbook.createFont();
        // 加粗
        font.setBold(true);


        // 标题
        String[] titles = {"序号", "用户登录名", "用户姓名", "归属部门", "用户性别", "用户状态", "用户职务", "角色", "权限名称", "权限范围"};
        // 创建行
        Row row = sheet.createRow(0);  // 第一行
        row.setHeightInPoints(40);
        for (int i = 0; i < titles.length; i++) {
            // 设置单元格宽度
            sheet.setColumnWidth(i, 20 * 256);

            // 创建单元格
            Cell cell = row.createCell(i);
            cell.setCellValue(titles[i]);

            cellStyle.setFont(font);

            cell.setCellStyle(cellStyle);
        }

        font.setBold(false);
        cellStyle.setFont(font);

        for (int i = 0; i < list.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            row1.setHeightInPoints(30);  // 设置行高
            UserRoleAuthorityBean bean = list.get(i);

            // 角色
            Set<Role> roles = bean.getRoles();
            StringBuilder roleBuilder = new StringBuilder();
            Iterator<Role> iterator = roles.iterator();
            while (iterator.hasNext()) {
                Role next = iterator.next();
                if (iterator.hasNext()) {
                    roleBuilder.append(next.getRoleName()).append(",");
                } else {
                    roleBuilder.append(next.getRoleName());
                }
            }

            // 权限名称
            Set<Authority> authorities = bean.getAuthorities();
            StringBuilder authorityBuilder = new StringBuilder();
            Iterator<Authority> iterator1 = authorities.iterator();
            while (iterator1.hasNext()) {
                Authority next = iterator1.next();
                if (iterator1.hasNext()) {
                    authorityBuilder.append(next.getAuthorityName()).append(",");
                } else {
                    authorityBuilder.append(next.getAuthorityName());
                }
            }

            // 权限范围
            Set<Operation> operations = bean.getOperations();
            StringBuilder scopeBuilder = new StringBuilder();
            Iterator<Operation> iterator2 = operations.iterator();
            while (iterator2.hasNext()) {
                Operation next = iterator2.next();
                if (iterator2.hasNext()) {
                    scopeBuilder.append(next.getOperationName()).append(",");
                } else {
                    scopeBuilder.append(next.getOperationName());
                }
            }

            // 序号
            Cell numberCell = row1.createCell(0);
            numberCell.setCellValue(i + 1);
            numberCell.setCellStyle(cellStyle);
            // 用户登录名
            Cell accountCell = row1.createCell(1);
            accountCell.setCellValue(bean.getUserAccount());
            accountCell.setCellStyle(cellStyle);
            // 用户姓名
            Cell nameCell = row1.createCell(2);
            nameCell.setCellValue(bean.getUserName());
            nameCell.setCellStyle(cellStyle);
            // 归属部门
            Cell deptCell = row1.createCell(3);
            deptCell.setCellValue(bean.getDeptName());
            deptCell.setCellStyle(cellStyle);
            // 用户性别
            Cell sexCell = row1.createCell(4);
            sexCell.setCellValue((bean.getUserSex() == 1) ? "男" : "女");
            sexCell.setCellStyle(cellStyle);
            // 用户状态
            Cell stateCell = row1.createCell(5);
            stateCell.setCellValue((bean.getUserState() == 1) ? "有效" : "无效");
            stateCell.setCellStyle(cellStyle);
            // 用户职务
            Cell dutyCell = row1.createCell(6);
            dutyCell.setCellValue(bean.getDutyName());
            dutyCell.setCellStyle(cellStyle);
            // 角色
            Cell roleCell = row1.createCell(7);
            roleCell.setCellValue(roleBuilder.toString());
            roleCell.setCellStyle(cellStyle);
            // 权限名称
            Cell authCell = row1.createCell(8);
            authCell.setCellValue(authorityBuilder.toString());
            authCell.setCellStyle(cellStyle);
            // 权限范围
            Cell scopeCell = row1.createCell(9);
            scopeCell.setCellValue(scopeBuilder.toString());
            scopeCell.setCellStyle(cellStyle);

        }
        workbook.write(response.getOutputStream());
    }

}
