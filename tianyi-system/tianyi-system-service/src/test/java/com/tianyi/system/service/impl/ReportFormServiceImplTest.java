package com.tianyi.system.service.impl;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.Operation;
import com.tianyi.system.entity.Role;
import com.tianyi.system.service.IReportFormService;
import com.tianyi.system.vo.UserBean;
import com.tianyi.system.vo.UserRoleAuthorityBean;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author : LiYong
 * @program : ReportFormServiceImplTest
 * @description :
 * @date : 2019/9/13 16:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class ReportFormServiceImplTest {

    @Autowired
    private IReportFormService reportFormService;

    /**
     * 条件查询权限报表
     */
    @Test
    public void test01() {
        UserBean userBean = new UserBean();
        List<UserRoleAuthorityBean> list = reportFormService.listUserForm(userBean);
        System.out.println(list.size());
        for (UserRoleAuthorityBean bean : list) {
            System.out.println(bean.getRoles().toString());
            System.out.println(bean.getAuthorities());
            System.out.println(bean.getOperations());
        }
    }

    /**
     * 生成权限报表
     */
    @Test
    public void test02() throws Exception {
        List<UserRoleAuthorityBean> list = reportFormService.listUserForm(new UserBean());

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
            sheet.setColumnWidth(i,20*256);

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
                if (iterator.hasNext()){
                    roleBuilder.append(next.getRoleName()).append(",");
                }else {
                    roleBuilder.append(next.getRoleName());
                }
            }

            // 权限名称
            Set<Authority> authorities = bean.getAuthorities();
            StringBuilder authorityBuilder = new StringBuilder();
            Iterator<Authority> iterator1 = authorities.iterator();
            while (iterator1.hasNext()) {
                Authority next = iterator1.next();
                if (iterator1.hasNext()){
                    authorityBuilder.append(next.getAuthorityName()).append(",");
                }else {
                    authorityBuilder.append(next.getAuthorityName());
                }
            }

            // 权限范围
            Set<Operation> operations = bean.getOperations();
            StringBuilder scopeBuilder = new StringBuilder();
            Iterator<Operation> iterator2 = operations.iterator();
            while (iterator2.hasNext()) {
                Operation next = iterator2.next();
                if (iterator2.hasNext()){
                    scopeBuilder.append(next.getOperationName()).append(",");
                }else {
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

            workbook.write(new FileOutputStream("D:/权限报表.xlsx"));
        }
        workbook.close();
    }

}