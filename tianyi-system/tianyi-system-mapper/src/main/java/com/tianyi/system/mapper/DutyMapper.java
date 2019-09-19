package com.tianyi.system.mapper;

import com.tianyi.system.entity.Duty;
import com.tianyi.system.entity.DutyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DutyMapper {
    long countByExample(DutyExample example);

    int deleteByExample(DutyExample example);

    int deleteByPrimaryKey(Integer dutyId);

    int insert(Duty record);

    int insertSelective(Duty record);

    List<Duty> selectByExampleWithBLOBs(DutyExample example);

    List<Duty> selectByExample(DutyExample example);

    Duty selectByPrimaryKey(Integer dutyId);

    int updateByExampleSelective(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByExampleWithBLOBs(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByExample(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKeyWithBLOBs(Duty record);

    int updateByPrimaryKey(Duty record);
}