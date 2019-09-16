package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeReturnOrder;
import com.tianyi.trade.model.TradeReturnOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeReturnOrderMapper {
    long countByExample(TradeReturnOrderExample example);

    int deleteByExample(TradeReturnOrderExample example);

    int deleteByPrimaryKey(Long returnId);

    int insert(TradeReturnOrder record);

    int insertSelective(TradeReturnOrder record);

    List<TradeReturnOrder> selectByExample(TradeReturnOrderExample example);

    TradeReturnOrder selectByPrimaryKey(Long returnId);

    int updateByExampleSelective(@Param("record") TradeReturnOrder record, @Param("example") TradeReturnOrderExample example);

    int updateByExample(@Param("record") TradeReturnOrder record, @Param("example") TradeReturnOrderExample example);

    int updateByPrimaryKeySelective(TradeReturnOrder record);

    int updateByPrimaryKey(TradeReturnOrder record);
}