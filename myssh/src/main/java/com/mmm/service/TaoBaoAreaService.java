package com.mmm.service;

import com.mmm.model.TaoBaoArea;

public interface TaoBaoAreaService {
	
	TaoBaoArea selectTaoBaoAreaByIp(String Ip);
	int insertTaoBaoArea(TaoBaoArea taoBaoArea);
}
