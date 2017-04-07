package com.msy.module.common.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msy.module.common.dao.AreaMapper;
import com.msy.module.common.model.Area;
import com.msy.module.common.service.AreaService;
@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public void insertBenchData(List<Area> list) {
		this.areaMapper.insertBenchData(list);
	}

	@Override
	public void readAreaXmlFileAndSave(String path) throws Exception {
		//将xml转成
		SAXReader read = new SAXReader();
		Document doc = read.read(new File(path));
		List<Area> list = this.getAreaMap(doc.getRootElement(), "", new ArrayList<Area>());
		this.areaMapper.insertBenchData(list);
	}
	public List<Area> getAreaMap(Element element,String parentId,List<Area> list){
		String type = element.getName();
		if("Location".equals(type) && !element.elements().isEmpty()){
			for(Element ele:(List<Element>)element.elements()){
				if("中国".equals(ele.attribute("Name").getValue())){
					getAreaMap(ele, "", list);
				}
			}
		}else{
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			String name = element.attribute("Name").getValue();
			String code = element.attribute("Code").getValue();
			Area area = new Area();
			area.setId(id);
			area.setAreaName(name);
			area.setAreaCode(code);
			area.setPid(parentId);
			area.setType(type);
			list.add(area);
			if(!element.elements().isEmpty()){
				for(Element ele:(List<Element>)element.elements()){
					if("Region".equals(ele.getName())){
						continue;
					}
					getAreaMap(ele, id, list);
				}
			}
		}
		return list;
	}
}
