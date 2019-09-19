package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.ProposeStateAuthority;
import com.tianyi.goods.entity.ProposeStateAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProposeStateAuthorityMapper {
    long countByExample(ProposeStateAuthorityExample example);

    int deleteByExample(ProposeStateAuthorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProposeStateAuthority record);

    int insertSelective(ProposeStateAuthority record);

    List<ProposeStateAuthority> selectByExample(ProposeStateAuthorityExample example);

    ProposeStateAuthority selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProposeStateAuthority record, @Param("example") ProposeStateAuthorityExample example);

    int updateByExample(@Param("record") ProposeStateAuthority record, @Param("example") ProposeStateAuthorityExample example);

    int updateByPrimaryKeySelective(ProposeStateAuthority record);

    int updateByPrimaryKey(ProposeStateAuthority record);
}