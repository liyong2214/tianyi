package com.tianyi.system.mapper;

import com.tianyi.system.entity.SystemLog;
import com.tianyi.system.entity.SystemLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemLogMapper {
    long countByExample(SystemLogExample example);

    int deleteByExample(SystemLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    List<SystemLog> selectByExample(SystemLogExample example);

    SystemLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    int updateByExample(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}