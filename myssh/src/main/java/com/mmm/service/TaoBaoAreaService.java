package com.mmm.service;

import com.mmm.model.City;
import com.mmm.model.Country;
import com.mmm.model.IP;
import com.mmm.model.SP;
import com.mmm.model.TaoBaoArea;

public interface TaoBaoAreaService {
	//操作总表数据
	TaoBaoArea selectTaoBaoAreaByIp(String Ip);
	TaoBaoArea selectTaoBaoAreaByIp2(String Ip);
	int insertTaoBaoArea(TaoBaoArea taoBaoArea);
	//分表数据
	//sp表
	int insertSP(SP sp);
	int insertCity(City city);
	int insertCountry(Country country);
	int insertIP(IP ip);
	
	IP selectByPrimaryKey(String ip);
	int insertTaoBaoAreaAndChildTable(TaoBaoArea taoBaoArea);
	
}
