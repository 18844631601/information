package com.smg.ssm.mapper;

import com.smg.ssm.po.Award;

public interface AwardMapper {
    int deleteByPrimaryKey(Integer awardId);

    int insert(Award record);

    int insertSelective(Award record);

    Award selectByPrimaryKey(Integer awardId);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);
}