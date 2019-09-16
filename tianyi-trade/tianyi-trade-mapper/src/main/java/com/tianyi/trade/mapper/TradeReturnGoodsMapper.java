package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeReturnGoods;
import com.tianyi.trade.model.TradeReturnGoodsExample;
import com.tianyi.trade.model.TradeReturnGoodsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeReturnGoodsMapper {
    long countByExample(TradeReturnGoodsExample example);

    int deleteByExample(TradeReturnGoodsExample example);

    int deleteByPrimaryKey(TradeReturnGoodsKey key);

    int insert(TradeReturnGoods record);

    int insertSelective(TradeReturnGoods record);

    List<TradeReturnGoods> selectByExample(TradeReturnGoodsExample example);

    TradeReturnGoods selectByPrimaryKey(TradeReturnGoodsKey key);

    int updateByExampleSelective(@Param("record") TradeReturnGoods record, @Param("example") TradeReturnGoodsExample example);

    int updateByExample(@Param("record") TradeReturnGoods record, @Param("example") TradeReturnGoodsExample example);

    int updateByPrimaryKeySelective(TradeReturnGoods record);

    int updateByPrimaryKey(TradeReturnGoods record);
}