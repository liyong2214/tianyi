package com.tianyi.system.mapper;

import com.tianyi.system.entity.AuthorityOperationExample;
import com.tianyi.system.entity.AuthorityOperationKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityOperationMapper {
    long countByExample(AuthorityOperationExample example);

    int deleteByExample(AuthorityOperationExample example);

    int deleteByPrimaryKey(AuthorityOperationKey key);

    int insert(AuthorityOperationKey record);

    int insertSelective(AuthorityOperationKey record);

    List<AuthorityOperationKey> selectByExample(AuthorityOperationExample example);

    int updateByExampleSelective(@Param("record") AuthorityOperationKey record, @Param("example") AuthorityOperationExample example);

    int updateByExample(@Param("record") AuthorityOperationKey record, @Param("example") AuthorityOperationExample example);
}