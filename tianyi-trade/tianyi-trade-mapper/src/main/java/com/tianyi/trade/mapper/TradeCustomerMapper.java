package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeCustomer;
import com.tianyi.trade.model.TradeCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeCustomerMapper {
    long countByExample(TradeCustomerExample example);

    int deleteByExample(TradeCustomerExample example);

    int deleteByPrimaryKey(Long customerId);

    int insert(TradeCustomer record);

    int insertSelective(TradeCustomer record);

    List<TradeCustomer> selectByExample(TradeCustomerExample example);

    TradeCustomer selectByPrimaryKey(Long customerId);

    int updateByExampleSelective(@Param("record") TradeCustomer record, @Param("example") TradeCustomerExample example);

    int updateByExample(@Param("record") TradeCustomer record, @Param("example") TradeCustomerExample example);

    int updateByPrimaryKeySelective(TradeCustomer record);

    int updateByPrimaryKey(TradeCustomer record);
}