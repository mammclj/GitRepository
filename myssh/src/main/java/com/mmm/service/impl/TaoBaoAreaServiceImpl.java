package com.mmm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.dao.TaoBaoAreaMapper;
import com.mmm.model.TaoBaoArea;
import com.mmm.service.TaoBaoAreaService;
@Service("taoBaoAreaService")
public class TaoBaoAreaServiceImpl implements TaoBaoAreaService {

	@Autowired
	private TaoBaoAreaMapper taoBaoAreaMapper;

	@Override
	public TaoBaoArea selectTaoBaoAreaByIp(String ip) {
		return this.taoBaoAreaMapper.selectTaoBaoAreaByIp(ip);
	}

	@Override
	public int insertTaoBaoArea(TaoBaoArea taoBaoArea) {
		return this.taoBaoAreaMapper.insert(taoBaoArea);
	}
	
	
}
