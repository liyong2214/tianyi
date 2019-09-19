package com.tianyi.goods.mapper;


import com.tianyi.goods.entity.GoodsKinds;
import com.tianyi.goods.entity.GoodsKindsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsKindsMapper {
    long countByExample(GoodsKindsExample example);

    int deleteByExample(GoodsKindsExample example);

    int deleteByPrimaryKey(Long kindId);

    int insert(GoodsKinds record);

    int insertSelective(GoodsKinds record);

    List<GoodsKinds> selectByExampleWithBLOBs(GoodsKindsExample example);

    List<GoodsKinds> selectByExample(GoodsKindsExample example);

    GoodsKinds selectByPrimaryKey(Long kindId);

    int updateByExampleSelective(@Param("record") GoodsKinds record, @Param("example") GoodsKindsExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsKinds record, @Param("example") GoodsKindsExample example);

    int updateByExample(@Param("record") GoodsKinds record, @Param("example") GoodsKindsExample example);

    int updateByPrimaryKeySelective(GoodsKinds record);

    int updateByPrimaryKeyWithBLOBs(GoodsKinds record);

    int updateByPrimaryKey(GoodsKinds record);
}