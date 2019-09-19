package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.GoodsPricePropose;
import com.tianyi.goods.entity.GoodsPriceProposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsPriceProposeMapper {
    long countByExample(GoodsPriceProposeExample example);

    int deleteByExample(GoodsPriceProposeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPricePropose record);

    int insertSelective(GoodsPricePropose record);

    List<GoodsPricePropose> selectByExampleWithBLOBs(GoodsPriceProposeExample example);

    List<GoodsPricePropose> selectByExample(GoodsPriceProposeExample example);

    GoodsPricePropose selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsPricePropose record, @Param("example") GoodsPriceProposeExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsPricePropose record, @Param("example") GoodsPriceProposeExample example);

    int updateByExample(@Param("record") GoodsPricePropose record, @Param("example") GoodsPriceProposeExample example);

    int updateByPrimaryKeySelective(GoodsPricePropose record);

    int updateByPrimaryKeyWithBLOBs(GoodsPricePropose record);

    int updateByPrimaryKey(GoodsPricePropose record);
}