package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.RoleDepartmentExample;
import com.tianyi.goods.entity.RoleDepartmentKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDepartmentMapper {
    long countByExample(RoleDepartmentExample example);

    int deleteByExample(RoleDepartmentExample example);

    int deleteByPrimaryKey(RoleDepartmentKey key);

    int insert(RoleDepartmentKey record);

    int insertSelective(RoleDepartmentKey record);

    List<RoleDepartmentKey> selectByExample(RoleDepartmentExample example);

    int updateByExampleSelective(@Param("record") RoleDepartmentKey record, @Param("example") RoleDepartmentExample example);

    int updateByExample(@Param("record") RoleDepartmentKey record, @Param("example") RoleDepartmentExample example);
}