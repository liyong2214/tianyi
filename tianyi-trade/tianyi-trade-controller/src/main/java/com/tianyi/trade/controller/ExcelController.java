package com.tianyi.trade.controller;

import com.tianyi.trade.model.VO.OrderVO;
import com.tianyi.trade.service.ITradeOrderService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * @author : Hens
 * @date : 2019/9/11 21:59
 */
@RestController
@RequestMapping("orders")
@CrossOrigin
public class ExcelController {

    private final ITradeOrderService tradeOrderService;

    @Autowired
    public ExcelController(ITradeOrderService tradeOrderService) {
        this.tradeOrderService = tradeOrderService;
    }

    /**
     * 导出选中的订单
     * @param ids 选中的订单序号
     * @param response 响应
     * @throws IOException IO流异常
     */
    @PostMapping(value = "/excel")
    public void exportExcel(List<Long> ids,HttpServletResponse response) throws IOException {
        XSSFWorkbook sheets = new XSSFWorkbook();
        Sheet sheet = sheets.createSheet("销售订单");
        Row rowTitle = sheet.createRow(0);
        String [] titles = {"序号","订单编号","订单类型","订单动作","业务类型","支付方式","配送方式","订单状态"};
        // 创建表头
        for (int i = 0; i < titles.length; i++) {
            Cell cell = rowTitle.createCell(i);
            cell.setCellValue(titles[i]);
        }
        // 获取信息
        List<OrderVO> orderVOList = tradeOrderService.excelOrderVO(ids);
        for (int i = 0; i < orderVOList.size(); i++) {
            Row row = sheet.createRow(i+1);
            Cell idCell = row.createCell(0);
            idCell.setCellValue(orderVOList.get(i).getId());
            Cell orderCell = row.createCell(1);
            orderCell.setCellValue(orderVOList.get(i).getOrderId());
            Cell sourceCell = row.createCell(2);
            sourceCell.setCellValue(orderVOList.get(i).getResourceId());
            Cell actionCell = row.createCell(3);
            actionCell.setCellValue(orderVOList.get(i).getActionId());
            Cell tradeTypeCell = row.createCell(4);
            tradeTypeCell.setCellValue(orderVOList.get(i).getTradeType());
            Cell payCell = row.createCell(5);
            payCell.setCellValue(orderVOList.get(i).getPayType());
            Cell expressCell = row.createCell(6);
            expressCell.setCellValue(orderVOList.get(i).getExpressType());
            Cell stateCell = row.createCell(7);
            stateCell.setCellValue(orderVOList.get(i).getOrderState());
        }
        sheets.write(response.getOutputStream());
    }
}
