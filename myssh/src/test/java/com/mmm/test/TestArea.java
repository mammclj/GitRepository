package com.mmm.test;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.mmm.commons.CommonUtils;
import com.mmm.jsonModel.TaoBaoAreaData;
import com.mmm.model.TaoBaoArea;
import com.mmm.service.TaoBaoAreaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestArea {

	private static final Logger logger = Logger.getLogger(TestArea.class);

	@Autowired
	private TaoBaoAreaService taoBaoAreaService;
	
	@Test
	public void test(){
		TaoBaoAreaData taoBaoAreaData = new TaoBaoAreaData();
		try {
			String ip = "101.254.183.41";
			logger.info("请求地址真实ip是---------------------------------> "+ip);
			String paramIp = ip = ip.substring(0, ip.lastIndexOf("."))+".0";
			logger.info("只要获取ip的前三段就可以确定所属地信息了，此参数ip为--------> paramIp:"+paramIp);
			//查看数据库中是否有此ip
			TaoBaoArea taoBaoArea = this.taoBaoAreaService.selectTaoBaoAreaByIp(paramIp);
			if(taoBaoArea!=null){
				taoBaoAreaData.setCode(0);
				taoBaoAreaData.setTaoBaoArea(taoBaoArea);
			}else{
				//往数据库插入ip相关信息
				String result = CommonUtils.getAddressByIP(paramIp);
				if(!"".equals(result.trim())){
					result = result.replaceAll("_id", "Id").replace("data", "taoBaoArea");
					//json转对象
					taoBaoAreaData = JSON.toJavaObject(JSON.parseObject(result), TaoBaoAreaData.class);
					taoBaoArea = taoBaoAreaData.getTaoBaoArea();
					if(taoBaoArea!=null){
						taoBaoArea.setId(UUID.randomUUID().toString().replaceAll("-", ""));
						this.taoBaoAreaService.insertTaoBaoArea(taoBaoArea);
					}
				}else{
					taoBaoAreaData.setCode(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			logger.info(JSON.toJSONString(taoBaoAreaData));
		}
	}
	
}
