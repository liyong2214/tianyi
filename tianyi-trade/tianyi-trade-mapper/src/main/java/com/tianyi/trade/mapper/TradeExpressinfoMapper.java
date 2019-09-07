package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeExpressinfo;
import com.tianyi.trade.model.TradeExpressinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeExpressinfoMapper {
    long countByExample(TradeExpressinfoExample example);

    int deleteByExample(TradeExpressinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeExpressinfo record);

    int insertSelective(TradeExpressinfo record);

    List<TradeExpressinfo> selectByExample(TradeExpressinfoExample example);

    TradeExpressinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeExpressinfo record, @Param("example") TradeExpressinfoExample example);

    int updateByExample(@Param("record") TradeExpressinfo record, @Param("example") TradeExpressinfoExample example);

    int updateByPrimaryKeySelective(TradeExpressinfo record);

    int updateByPrimaryKey(TradeExpressinfo record);
}