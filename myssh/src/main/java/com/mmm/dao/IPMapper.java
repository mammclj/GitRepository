package com.mmm.dao;

import com.mmm.model.IP;

public interface IPMapper {
    int deleteByPrimaryKey(String ip);

    int insert(IP record);

    int insertSelective(IP record);

    IP selectByPrimaryKey(String ip);

    int updateByPrimaryKeySelective(IP record);

    int updateByPrimaryKey(IP record);
}