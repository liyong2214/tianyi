package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeOrderinfoSeries;
import com.tianyi.trade.model.TradeOrderinfoSeriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderinfoSeriesMapper {
    long countByExample(TradeOrderinfoSeriesExample example);

    int deleteByExample(TradeOrderinfoSeriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeOrderinfoSeries record);

    int insertSelective(TradeOrderinfoSeries record);

    List<TradeOrderinfoSeries> selectByExample(TradeOrderinfoSeriesExample example);

    TradeOrderinfoSeries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeOrderinfoSeries record, @Param("example") TradeOrderinfoSeriesExample example);

    int updateByExample(@Param("record") TradeOrderinfoSeries record, @Param("example") TradeOrderinfoSeriesExample example);

    int updateByPrimaryKeySelective(TradeOrderinfoSeries record);

    int updateByPrimaryKey(TradeOrderinfoSeries record);
}