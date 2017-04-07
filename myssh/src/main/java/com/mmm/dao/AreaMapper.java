package com.mmm.dao;

import java.util.List;

import com.mmm.model.Area;

public interface AreaMapper extends BaseMapper<Area> {
	void insertBenchData(List<Area> list);
}