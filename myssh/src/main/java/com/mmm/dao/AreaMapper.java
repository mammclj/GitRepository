package com.mmm.dao;

import java.util.List;

import com.mmm.model.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(String id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

	void insertBenchData(List<Area> list);
}