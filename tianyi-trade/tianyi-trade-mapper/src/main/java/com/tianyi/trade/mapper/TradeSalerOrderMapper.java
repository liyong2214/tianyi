package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TradeSalerOrder;
import com.tianyi.trade.model.TradeSalerOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeSalerOrderMapper {
    long countByExample(TradeSalerOrderExample example);

    int deleteByExample(TradeSalerOrderExample example);

    int deleteByPrimaryKey(Long saleId);

    int insert(TradeSalerOrder record);

    int insertSelective(TradeSalerOrder record);

    List<TradeSalerOrder> selectByExample(TradeSalerOrderExample example);

    TradeSalerOrder selectByPrimaryKey(Long saleId);

    int updateByExampleSelective(@Param("record") TradeSalerOrder record, @Param("example") TradeSalerOrderExample example);

    int updateByExample(@Param("record") TradeSalerOrder record, @Param("example") TradeSalerOrderExample example);

    int updateByPrimaryKeySelective(TradeSalerOrder record);

    int updateByPrimaryKey(TradeSalerOrder record);
}