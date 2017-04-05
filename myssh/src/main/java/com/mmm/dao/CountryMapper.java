package com.mmm.dao;

import com.mmm.model.Country;

public interface CountryMapper {
    int deleteByPrimaryKey(String countryId);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(String countryId);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}