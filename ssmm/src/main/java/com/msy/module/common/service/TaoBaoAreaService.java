package com.msy.module.common.service;

import com.msy.module.common.model.City;
import com.msy.module.common.model.Country;
import com.msy.module.common.model.IP;
import com.msy.module.common.model.Region;
import com.msy.module.common.model.SP;
import com.msy.module.common.model.TaoBaoArea;

public interface TaoBaoAreaService {
	//操作总表数据
	TaoBaoArea selectTaoBaoAreaByIp(String Ip);
	TaoBaoArea selectTaoBaoAreaByIp2(String Ip);
	int insertTaoBaoArea(TaoBaoArea taoBaoArea);
	//分表数据
	//sp表
	int insertSP(SP sp);
	int insertCity(City city);
	int insertRegion(Region region);
	int insertCountry(Country country);
	int insertIP(IP ip);
	
	IP selectByPrimaryKey(String ip);
	int insertTaoBaoAreaAndChildTable(TaoBaoArea taoBaoArea);
	
}
