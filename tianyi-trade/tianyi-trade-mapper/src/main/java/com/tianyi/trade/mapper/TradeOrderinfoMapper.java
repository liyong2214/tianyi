package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeOrderinfo;
import com.tianyi.trade.model.TradeOrderinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderinfoMapper {
    long countByExample(TradeOrderinfoExample example);

    int deleteByExample(TradeOrderinfoExample example);

    int deleteByPrimaryKey(Long orderinfoId);

    int insert(TradeOrderinfo record);

    int insertSelective(TradeOrderinfo record);

    List<TradeOrderinfo> selectByExample(TradeOrderinfoExample example);

    TradeOrderinfo selectByPrimaryKey(Long orderinfoId);

    int updateByExampleSelective(@Param("record") TradeOrderinfo record, @Param("example") TradeOrderinfoExample example);

    int updateByExample(@Param("record") TradeOrderinfo record, @Param("example") TradeOrderinfoExample example);

    int updateByPrimaryKeySelective(TradeOrderinfo record);

    int updateByPrimaryKey(TradeOrderinfo record);
}