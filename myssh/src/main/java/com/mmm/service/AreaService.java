package com.mmm.service;

import java.util.List;

import com.mmm.model.Area;

public interface AreaService {

	/**
	 * 批量保存地区数据
	 * @param list
	 */
	void insertBenchData(List<Area> list);
	/**
	 * 通过xml文件路径找到地区xml文件并读取保存入库
	 * @param path   地区xml文件路径
	 * @throws Exception
	 */
	void readAreaXmlFileAndSave(String path)throws Exception;
	
}
