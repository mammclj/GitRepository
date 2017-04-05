package com.mmm.dao;

import com.mmm.model.SP;

public interface SPMapper {
    int deleteByPrimaryKey(Integer spId);

    int insert(SP record);

    int insertSelective(SP record);

    SP selectByPrimaryKey(Integer spId);

    int updateByPrimaryKeySelective(SP record);

    int updateByPrimaryKey(SP record);
}