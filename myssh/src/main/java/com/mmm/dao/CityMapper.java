package com.mmm.dao;

import com.mmm.model.City;

public interface CityMapper {
    int deleteByPrimaryKey(String cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}