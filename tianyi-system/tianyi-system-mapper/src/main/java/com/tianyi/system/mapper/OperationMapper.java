package com.tianyi.system.mapper;

import com.tianyi.system.entity.Operation;
import com.tianyi.system.entity.OperationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationMapper {
    long countByExample(OperationExample example);

    int deleteByExample(OperationExample example);

    int deleteByPrimaryKey(Integer operationId);

    int insert(Operation record);

    int insertSelective(Operation record);

    List<Operation> selectByExampleWithBLOBs(OperationExample example);

    List<Operation> selectByExample(OperationExample example);

    Operation selectByPrimaryKey(Integer operationId);

    int updateByExampleSelective(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByExampleWithBLOBs(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByExample(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKeyWithBLOBs(Operation record);

    int updateByPrimaryKey(Operation record);
}