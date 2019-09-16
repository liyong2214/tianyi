package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TGoods;
import com.tianyi.trade.model.TGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGoodsMapper {
    long countByExample(TGoodsExample example);

    int deleteByExample(TGoodsExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(TGoods record);

    int insertSelective(TGoods record);

    List<TGoods> selectByExample(TGoodsExample example);

    TGoods selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByExample(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByPrimaryKeySelective(TGoods record);

    int updateByPrimaryKey(TGoods record);
}