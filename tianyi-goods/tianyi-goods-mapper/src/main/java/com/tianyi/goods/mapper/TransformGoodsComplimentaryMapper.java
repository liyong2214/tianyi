package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.TransformGoodsComplimentary;
import com.tianyi.goods.entity.TransformGoodsComplimentaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransformGoodsComplimentaryMapper {
    long countByExample(TransformGoodsComplimentaryExample example);

    int deleteByExample(TransformGoodsComplimentaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransformGoodsComplimentary record);

    int insertSelective(TransformGoodsComplimentary record);

    List<TransformGoodsComplimentary> selectByExample(TransformGoodsComplimentaryExample example);

    TransformGoodsComplimentary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransformGoodsComplimentary record, @Param("example") TransformGoodsComplimentaryExample example);

    int updateByExample(@Param("record") TransformGoodsComplimentary record, @Param("example") TransformGoodsComplimentaryExample example);

    int updateByPrimaryKeySelective(TransformGoodsComplimentary record);

    int updateByPrimaryKey(TransformGoodsComplimentary record);
}