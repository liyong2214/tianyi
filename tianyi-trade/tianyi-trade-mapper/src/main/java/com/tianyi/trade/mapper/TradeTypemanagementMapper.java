package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeTypemanagement;
import com.tianyi.trade.model.TradeTypemanagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeTypemanagementMapper {
    long countByExample(TradeTypemanagementExample example);

    int deleteByExample(TradeTypemanagementExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(TradeTypemanagement record);

    int insertSelective(TradeTypemanagement record);

    List<TradeTypemanagement> selectByExample(TradeTypemanagementExample example);

    TradeTypemanagement selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") TradeTypemanagement record, @Param("example") TradeTypemanagementExample example);

    int updateByExample(@Param("record") TradeTypemanagement record, @Param("example") TradeTypemanagementExample example);

    int updateByPrimaryKeySelective(TradeTypemanagement record);

    int updateByPrimaryKey(TradeTypemanagement record);
}