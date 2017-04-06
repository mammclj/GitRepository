package com.mmm.dao;

import com.mmm.model.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(String regionId);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(String regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}