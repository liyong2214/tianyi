package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.RoleAuthorityExample;
import com.tianyi.goods.entity.RoleAuthorityKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthorityMapper {
    long countByExample(RoleAuthorityExample example);

    int deleteByExample(RoleAuthorityExample example);

    int deleteByPrimaryKey(RoleAuthorityKey key);

    int insert(RoleAuthorityKey record);

    int insertSelective(RoleAuthorityKey record);

    List<RoleAuthorityKey> selectByExample(RoleAuthorityExample example);

    int updateByExampleSelective(@Param("record") RoleAuthorityKey record, @Param("example") RoleAuthorityExample example);

    int updateByExample(@Param("record") RoleAuthorityKey record, @Param("example") RoleAuthorityExample example);
}