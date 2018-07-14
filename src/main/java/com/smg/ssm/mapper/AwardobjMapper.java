package com.smg.ssm.mapper;

import com.smg.ssm.po.Awardobj;

public interface AwardobjMapper {
    int deleteByPrimaryKey(Integer awardobjId);

    int insert(Awardobj record);

    int insertSelective(Awardobj record);

    Awardobj selectByPrimaryKey(Integer awardobjId);

    int updateByPrimaryKeySelective(Awardobj record);

    int updateByPrimaryKey(Awardobj record);
}