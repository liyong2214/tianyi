package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TGoodsBrand;
import com.tianyi.trade.model.TGoodsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGoodsBrandMapper {
    long countByExample(TGoodsBrandExample example);

    int deleteByExample(TGoodsBrandExample example);

    int deleteByPrimaryKey(Long brandId);

    int insert(TGoodsBrand record);

    int insertSelective(TGoodsBrand record);

    List<TGoodsBrand> selectByExample(TGoodsBrandExample example);

    TGoodsBrand selectByPrimaryKey(Long brandId);

    int updateByExampleSelective(@Param("record") TGoodsBrand record, @Param("example") TGoodsBrandExample example);

    int updateByExample(@Param("record") TGoodsBrand record, @Param("example") TGoodsBrandExample example);

    int updateByPrimaryKeySelective(TGoodsBrand record);

    int updateByPrimaryKey(TGoodsBrand record);
}