package com.smg.ssm.mapper;

import com.smg.ssm.po.Paper;

public interface PaperMapper {
    int deleteByPrimaryKey(String paperId);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(String paperId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
}