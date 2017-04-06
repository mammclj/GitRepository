package com.mmm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.dao.CityMapper;
import com.mmm.dao.CountryMapper;
import com.mmm.dao.IPMapper;
import com.mmm.dao.RegionMapper;
import com.mmm.dao.SPMapper;
import com.mmm.dao.TaoBaoAreaMapper;
import com.mmm.model.City;
import com.mmm.model.Country;
import com.mmm.model.IP;
import com.mmm.model.Region;
import com.mmm.model.SP;
import com.mmm.model.TaoBaoArea;
import com.mmm.service.TaoBaoAreaService;

@Service("taoBaoAreaService")
public class TaoBaoAreaServiceImpl implements TaoBaoAreaService {

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
	public TaoBaoArea selectTaoBaoAreaByIp(String ip) {
		return this.taoBaoAreaMapper.selectTaoBaoAreaByIp(ip);
	}
	
	@Override
	public TaoBaoArea selectTaoBaoAreaByIp2(String ip) {
		IP ipModel = this.ipMapper.selectByPrimaryKey(ip);
		TaoBaoArea taoBaoArea = new TaoBaoArea();
		taoBaoArea.setCityId(ipModel.getCountryId());
		taoBaoArea.setCountryId(ipModel.getCountryId());
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
		
		IP ipModel = this.ipMapper.selectByPrimaryKey(taoBaoArea.getIp());
		if(ipModel==null){
			ipModel = new IP(ip,countryId,regionId,cityId,ispId);
			result = this.ipMapper.insert(ipModel);
		}
		
		return result;
	}

}
