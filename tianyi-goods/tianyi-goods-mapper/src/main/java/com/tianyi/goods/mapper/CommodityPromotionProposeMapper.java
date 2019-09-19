package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.CommodityPromotionPropose;
import com.tianyi.goods.entity.CommodityPromotionProposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityPromotionProposeMapper {
    long countByExample(CommodityPromotionProposeExample example);

    int deleteByExample(CommodityPromotionProposeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommodityPromotionPropose record);

    int insertSelective(CommodityPromotionPropose record);

    List<CommodityPromotionPropose> selectByExampleWithBLOBs(CommodityPromotionProposeExample example);

    List<CommodityPromotionPropose> selectByExample(CommodityPromotionProposeExample example);

    CommodityPromotionPropose selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommodityPromotionPropose record, @Param("example") CommodityPromotionProposeExample example);

    int updateByExampleWithBLOBs(@Param("record") CommodityPromotionPropose record, @Param("example") CommodityPromotionProposeExample example);

    int updateByExample(@Param("record") CommodityPromotionPropose record, @Param("example") CommodityPromotionProposeExample example);

    int updateByPrimaryKeySelective(CommodityPromotionPropose record);

    int updateByPrimaryKeyWithBLOBs(CommodityPromotionPropose record);

    int updateByPrimaryKey(CommodityPromotionPropose record);
}