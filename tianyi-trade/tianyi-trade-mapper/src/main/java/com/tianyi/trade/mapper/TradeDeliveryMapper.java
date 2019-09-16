package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeDelivery;
import com.tianyi.trade.model.TradeDeliveryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeDeliveryMapper {
    long countByExample(TradeDeliveryExample example);

    int deleteByExample(TradeDeliveryExample example);

    int deleteByPrimaryKey(Long deliveryId);

    int insert(TradeDelivery record);

    int insertSelective(TradeDelivery record);

    List<TradeDelivery> selectByExample(TradeDeliveryExample example);

    TradeDelivery selectByPrimaryKey(Long deliveryId);

    int updateByExampleSelective(@Param("record") TradeDelivery record, @Param("example") TradeDeliveryExample example);

    int updateByExample(@Param("record") TradeDelivery record, @Param("example") TradeDeliveryExample example);

    int updateByPrimaryKeySelective(TradeDelivery record);

    int updateByPrimaryKey(TradeDelivery record);
}