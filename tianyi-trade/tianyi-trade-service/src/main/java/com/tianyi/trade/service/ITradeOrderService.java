package com.tianyi.trade.service;

import com.tianyi.trade.model.VO.*;

import java.util.List;
/**
 * @author : Hens
 * @date : 2019/9/8 13:41
 */
public interface ITradeOrderService {

    /**
     * 接收天翼订单信息并加入数据库
     * @param tradeOrderVO 传入的信息
     * @return 添加结果的数量
     */
    public Integer saveOrder(TradeOrderVO tradeOrderVO);

    /**
     * 分页查询订单
     * @param currentPage 当前数据
     * @param pageSize 每页显示数据量
     * @return 返回分页数据
     */
    public List<OrderVO> listOrderVO(Integer currentPage,Integer pageSize);

    /**
     * 查询单个订单信息
     * @param id 订单编号
     * @return 返回订单详情信息
     */
    public OrderInfoVO getOrderInfo(Long id);

    /**
     * 根据id 导出excel
     * @param ids 传入的订单序号
     * @return 返回选中订单信息
     */
    public List<OrderVO> excelOrderVO(List<Long> ids);
}
