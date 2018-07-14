package com.smg.ssm.mapper;

import com.smg.ssm.po.Patent;

public interface PatentMapper {
    int deleteByPrimaryKey(String patentId);

    int insert(Patent record);

    int insertSelective(Patent record);

    Patent selectByPrimaryKey(String patentId);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record);
}