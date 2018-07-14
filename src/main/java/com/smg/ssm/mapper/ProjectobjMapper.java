package com.smg.ssm.mapper;

import com.smg.ssm.po.Projectobj;

public interface ProjectobjMapper {
    int deleteByPrimaryKey(Integer projectobjId);

    int insert(Projectobj record);

    int insertSelective(Projectobj record);

    Projectobj selectByPrimaryKey(Integer projectobjId);

    int updateByPrimaryKeySelective(Projectobj record);

    int updateByPrimaryKey(Projectobj record);
}