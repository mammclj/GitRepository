package com.msy.module.common.dao;

import java.util.List;

import com.msy.module.common.model.Area;

public interface AreaMapper extends BaseMapper<Area> {
	void insertBenchData(List<Area> list);
}