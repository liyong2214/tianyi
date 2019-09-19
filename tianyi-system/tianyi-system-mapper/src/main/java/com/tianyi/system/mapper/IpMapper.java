package com.tianyi.system.mapper;

import com.tianyi.system.entity.Ip;
import com.tianyi.system.entity.IpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IpMapper {
    long countByExample(IpExample example);

    int deleteByExample(IpExample example);

    int deleteByPrimaryKey(Integer ipId);

    int insert(Ip record);

    int insertSelective(Ip record);

    List<Ip> selectByExampleWithBLOBs(IpExample example);

    List<Ip> selectByExample(IpExample example);

    Ip selectByPrimaryKey(Integer ipId);

    int updateByExampleSelective(@Param("record") Ip record, @Param("example") IpExample example);

    int updateByExampleWithBLOBs(@Param("record") Ip record, @Param("example") IpExample example);

    int updateByExample(@Param("record") Ip record, @Param("example") IpExample example);

    int updateByPrimaryKeySelective(Ip record);

    int updateByPrimaryKeyWithBLOBs(Ip record);

    int updateByPrimaryKey(Ip record);
}