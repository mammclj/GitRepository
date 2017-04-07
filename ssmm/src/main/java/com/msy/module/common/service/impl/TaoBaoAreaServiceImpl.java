package com.msy.module.common.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.module.common.dao.CityMapper;
import com.msy.module.common.dao.CountryMapper;
import com.msy.module.common.dao.IPMapper;
import com.msy.module.common.dao.RegionMapper;
import com.msy.module.common.dao.SPMapper;
import com.msy.module.common.dao.TaoBaoAreaMapper;
import com.msy.module.common.model.City;
import com.msy.module.common.model.Country;
import com.msy.module.common.model.IP;
import com.msy.module.common.model.Region;
import com.msy.module.common.model.SP;
import com.msy.module.common.model.TaoBaoArea;
import com.msy.module.common.service.TaoBaoAreaService;
import com.msy.module.common.util.dataSource.DataSource;

@Service("taoBaoAreaService")
public class TaoBaoAreaServiceImpl implements TaoBaoAreaService {

	private static Logger logger = Logger.getLogger(TaoBaoAreaServiceImpl.class);
	@Autowired
	private TaoBaoAreaMapper taoBaoAreaMapper;
	@Autowired
	private IPMapper ipMapper;
	@Autowired
	private CountryMapper countryMapper;
	@Autowired
	private RegionMapper regionMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private SPMapper spMapper;

	@Override
	@Transactional
	@DataSource("dataSource2")
	public TaoBaoArea selectTaoBaoAreaByIp(String ip) {
		return this.taoBaoAreaMapper.selectTaoBaoAreaByIp(ip);
	}
	
	@Override
	@Transactional
	@DataSource("dataSource1")
	public TaoBaoArea selectTaoBaoAreaByIp2(String ip) {
		IP ipModel = this.ipMapper.selectByPrimaryKey(ip);
		TaoBaoArea taoBaoArea = new TaoBaoArea();
		taoBaoArea.setCountryId(ipModel.getCountryId());
		taoBaoArea.setRegionId(ipModel.getRegionId());
		taoBaoArea.setCityId(ipModel.getCountryId());
		return taoBaoArea;
	}

	@Override
	public int insertTaoBaoArea(TaoBaoArea taoBaoArea) {
		return this.taoBaoAreaMapper.insert(taoBaoArea);
	}

	@Override
	public int insertSP(SP sp) {
		return this.spMapper.insert(sp);
	}

	@Override
	public int insertCity(City city) {
		return this.cityMapper.insert(city);
	}
	
	@Override
	public int insertRegion(Region region) {
		return this.regionMapper.insert(region);
	}

	@Override
	public int insertCountry(Country country) {
		return this.countryMapper.insert(country);
	}

	@Override
	public int insertIP(IP ip) {
		return this.ipMapper.insert(ip);
	}

	@Override
	public IP selectByPrimaryKey(String ip) {
		return this.ipMapper.selectByPrimaryKey(ip);
	}

	@Override
	@Transactional
	@DataSource("dataSource1")
	public int insertTaoBaoAreaAndChildTable(TaoBaoArea taoBaoArea) {
		this.taoBaoAreaMapper.insert(taoBaoArea);
		int result = 0;
		String countryId = taoBaoArea.getCountryId();
		String regionId = taoBaoArea.getRegionId();
		String cityId = taoBaoArea.getCityId();
		int ispId = Integer.parseInt(taoBaoArea.getIspId());
		String ip = taoBaoArea.getIp();
		Country country = this.countryMapper.selectByPrimaryKey(countryId);
		if(country==null){
			country = new Country(countryId,taoBaoArea.getCountry());
			result = this.countryMapper.insert(country);
		}
		
		Region region = this.regionMapper.selectByPrimaryKey(regionId);
		if(region==null){
			region = new Region(regionId,taoBaoArea.getRegion());
			result = this.regionMapper.insert(region);
		}
		
		City city = this.cityMapper.selectByPrimaryKey(cityId);
		if(city==null){
			city = new City(cityId,taoBaoArea.getCity());
			result = this.cityMapper.insert(city);
		}
		
		SP sp = this.spMapper.selectByPrimaryKey(ispId);
		if(sp==null){
			sp = new SP(ispId,taoBaoArea.getIsp());
			result = this.spMapper.insert(sp);
		}
		logger.info(1/0);
		IP ipModel = this.ipMapper.selectByPrimaryKey(taoBaoArea.getIp());
		if(ipModel==null){
			ipModel = new IP(ip,countryId,regionId,cityId,ispId);
			result = this.ipMapper.insert(ipModel);
		}
		
		return result;
	}

}
