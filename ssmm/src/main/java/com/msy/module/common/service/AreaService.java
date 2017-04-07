package com.msy.module.common.service;

import java.util.List;

import com.msy.module.common.model.Area;

public interface AreaService {

	/**
	 * 批量保存地区数据
	 * @param list
	 */
	void insertBenchData(List<Area> list);
	/**这是QQ软件中的地域信息
	 * 通过xml文件路径找到地区xml文件并读取保存入库
	 	<Location>
		  <CountryRegion Name="中国" Code="1">
		    <State Name="北京" Code="11">
		      <City Name="东城" Code="1" />
		      <City Name="西城" Code="2" />
		    </State>
		    <State Name="河北" Code="13">
		      <City Name="石家庄" Code="1">
		        <Region Name="长安区" Code="2" />
		        <Region Name="桥东区" Code="3" />
		        <Region Name="桥西区" Code="4" />
		      </City>
		      <City Name="唐山" Code="2">
		        <Region Name="路南区" Code="2" />
		        <Region Name="路北区" Code="3" />
		      </City>
		    </State>
		  </CountryRegion>
		  <CountryRegion Name="阿尔巴尼亚" Code="ALB">
		    <State>
		      <City Name="爱尔巴桑" Code="EL" />
		      <City Name="迪勃拉" Code="DI" />
		      <City Name="地拉那" Code="TR" />
		      <City Name="都拉斯" Code="DR" />
		      <City Name="发罗拉" Code="VL" />
		      <City Name="费里" Code="FR" />
		      <City Name="吉诺卡斯特" Code="GJ" />
		      <City Name="科尔察" Code="KO" />
		      <City Name="库克斯" Code="KU" />
		      <City Name="莱什" Code="LE" />
		      <City Name="培拉特" Code="BR" />
		      <City Name="斯库台" Code="SH" />
		    </State>
		  </CountryRegion> 
		</Location>
	 * @param path   地区xml文件路径
	 * @throws Exception
	 */
	void readAreaXmlFileAndSave(String path)throws Exception;
	
}
