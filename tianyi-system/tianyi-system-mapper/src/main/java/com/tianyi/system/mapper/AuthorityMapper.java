package com.tianyi.system.mapper;

import com.tianyi.system.entity.Authority;
import com.tianyi.system.entity.AuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityMapper {
    long countByExample(AuthorityExample example);

    int deleteByExample(AuthorityExample example);

    int deleteByPrimaryKey(Integer authorityId);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExampleWithBLOBs(AuthorityExample example);

    List<Authority> selectByExample(AuthorityExample example);

    Authority selectByPrimaryKey(Integer authorityId);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExampleWithBLOBs(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKeyWithBLOBs(Authority record);

    int updateByPrimaryKey(Authority record);
}