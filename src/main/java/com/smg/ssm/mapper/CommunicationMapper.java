package com.smg.ssm.mapper;

import com.smg.ssm.po.Communication;

public interface CommunicationMapper {
    int deleteByPrimaryKey(Integer communicationId);

    int insert(Communication record);

    int insertSelective(Communication record);

    Communication selectByPrimaryKey(Integer communicationId);

    int updateByPrimaryKeySelective(Communication record);

    int updateByPrimaryKey(Communication record);
}