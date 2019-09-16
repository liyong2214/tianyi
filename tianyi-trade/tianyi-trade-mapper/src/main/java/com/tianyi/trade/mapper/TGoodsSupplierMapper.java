package com.tianyi.trade.mapper;

import com.tianyi.trade.model.TGoodsSupplier;
import com.tianyi.trade.model.TGoodsSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGoodsSupplierMapper {
    long countByExample(TGoodsSupplierExample example);

    int deleteByExample(TGoodsSupplierExample example);

    int deleteByPrimaryKey(Integer supplierId);

    int insert(TGoodsSupplier record);

    int insertSelective(TGoodsSupplier record);

    List<TGoodsSupplier> selectByExample(TGoodsSupplierExample example);

    TGoodsSupplier selectByPrimaryKey(Integer supplierId);

    int updateByExampleSelective(@Param("record") TGoodsSupplier record, @Param("example") TGoodsSupplierExample example);

    int updateByExample(@Param("record") TGoodsSupplier record, @Param("example") TGoodsSupplierExample example);

    int updateByPrimaryKeySelective(TGoodsSupplier record);

    int updateByPrimaryKey(TGoodsSupplier record);
}