package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TGoodsSeriesExample;
import com.tianyi.trade.model.TGoodsSeriesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGoodsSeriesMapper {
    long countByExample(TGoodsSeriesExample example);

    int deleteByExample(TGoodsSeriesExample example);

    int deleteByPrimaryKey(TGoodsSeriesKey key);

    int insert(TGoodsSeriesKey record);

    int insertSelective(TGoodsSeriesKey record);

    List<TGoodsSeriesKey> selectByExample(TGoodsSeriesExample example);

    int updateByExampleSelective(@Param("record") TGoodsSeriesKey record, @Param("example") TGoodsSeriesExample example);

    int updateByExample(@Param("record") TGoodsSeriesKey record, @Param("example") TGoodsSeriesExample example);
}