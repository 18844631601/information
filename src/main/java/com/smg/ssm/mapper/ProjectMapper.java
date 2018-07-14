package com.smg.ssm.mapper;

import com.smg.ssm.po.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}