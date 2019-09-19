package com.tianyi.goods.mapper;

import com.tianyi.goods.entity.ProposeApprove;
import com.tianyi.goods.entity.ProposeApproveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProposeApproveMapper {
    long countByExample(ProposeApproveExample example);

    int deleteByExample(ProposeApproveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProposeApprove record);

    int insertSelective(ProposeApprove record);

    List<ProposeApprove> selectByExample(ProposeApproveExample example);

    ProposeApprove selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProposeApprove record, @Param("example") ProposeApproveExample example);

    int updateByExample(@Param("record") ProposeApprove record, @Param("example") ProposeApproveExample example);

    int updateByPrimaryKeySelective(ProposeApprove record);

    int updateByPrimaryKey(ProposeApprove record);
}