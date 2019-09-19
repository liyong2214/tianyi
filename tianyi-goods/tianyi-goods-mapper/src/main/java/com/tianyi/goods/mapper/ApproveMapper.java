package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.Approve;
import com.tianyi.goods.entity.ApproveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApproveMapper {
    long countByExample(ApproveExample example);

    int deleteByExample(ApproveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Approve record);

    int insertSelective(Approve record);

    List<Approve> selectByExampleWithBLOBs(ApproveExample example);

    List<Approve> selectByExample(ApproveExample example);

    Approve selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Approve record, @Param("example") ApproveExample example);

    int updateByExampleWithBLOBs(@Param("record") Approve record, @Param("example") ApproveExample example);

    int updateByExample(@Param("record") Approve record, @Param("example") ApproveExample example);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKeyWithBLOBs(Approve record);

    int updateByPrimaryKey(Approve record);
}