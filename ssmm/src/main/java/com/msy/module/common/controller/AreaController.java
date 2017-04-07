package com.msy.module.common.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.msy.module.common.jsonModel.Json;
import com.msy.module.common.jsonModel.TaoBaoAreaData;
import com.msy.module.common.model.IP;
import com.msy.module.common.model.TaoBaoArea;
import com.msy.module.common.service.AreaService;
import com.msy.module.common.service.TaoBaoAreaService;
import com.msy.module.common.util.ip.IPUtil;

@Controller
@RequestMapping("/areaController")
public class AreaController {
	
	private static Logger logger = Logger.getLogger(AreaController.class);
	private static final String SUCCESS = "showUser";
	@Autowired
	private AreaService areaService;
	@Autowired
	private TaoBaoAreaService taoBaoAreaService;
	/**
	 * 读取xml数据并入库
	 * @param request
	 * @return
	 */
	@RequestMapping("/readAreaXmlFile")
	public String readXmlFile(HttpServletRequest request){
		String ip = IPUtil.getRealIp(request);
		logger.info("请求地址真实ip是---------------------------------> "+ip);
		//IPUtil.getAddressByIP(ip);
		String success = "地区数据保存入库失败";
		try {
			String path = "C:/Users/yanfa1/Desktop/LocList.xml";
			if(path!=null && !"".equals(path.trim())){
				this.areaService.readAreaXmlFileAndSave(path);
			}
			success = "地区数据保存入库成功";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			request.setAttribute("success", success);
		}
		return this.SUCCESS;
	}
	
	@RequestMapping("/showAreaInfoByIp")
	public String showAreaInfoByIp(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		TaoBaoAreaData taoBaoAreaData = new TaoBaoAreaData();
		try {
			out = response.getWriter();
			String ip = IPUtil.getRealIp(request);
			ip = "101.254.183.41";
			logger.info("请求地址真实ip是---------------------------------> "+ip);
//			ip = ip.substring(0, ip.lastIndexOf("."))+".0";
//			logger.info("只要获取ip的前三段就可以确定所属地信息了，此参数ip为--------> ip:"+ip);
			//查看数据库中是否有此ip
			TaoBaoArea taoBaoArea = this.taoBaoAreaService.selectTaoBaoAreaByIp(ip);
			taoBaoArea = this.taoBaoAreaService.selectTaoBaoAreaByIp2(ip);
			if(taoBaoArea!=null){
				taoBaoAreaData.setCode(0);
				taoBaoAreaData.setTaoBaoArea(taoBaoArea);
			}else{
				//往数据库插入ip相关信息
				String result = IPUtil.getAddressByIP(ip);
				if(result!=null && !"".equals(result.trim())){
					result = result.replaceAll("_id", "Id").replace("data", "taoBaoArea");
					//json转对象
					taoBaoAreaData = JSON.toJavaObject(JSON.parseObject(result), TaoBaoAreaData.class);
					taoBaoArea = taoBaoAreaData.getTaoBaoArea();
					if(taoBaoArea!=null){
						taoBaoArea.setId(UUID.randomUUID().toString().replaceAll("-", ""));
						if(this.taoBaoAreaService.insertTaoBaoArea(taoBaoArea)!=1){
							taoBaoAreaData.setCode(1);
						}
					}
				}else{
					taoBaoAreaData.setCode(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out !=null){
				out.print(JSON.toJSONString(taoBaoAreaData));
				out.close();
			}
		}
		return null;
	}
	
	@RequestMapping("/showAreaInfoByIp2")
	public String showAreaInfoByIp2(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		Json json = new Json(true,"",null);
		boolean success = true;
		Map<String,Object> map = new HashMap<String,Object>();
		String message = "查询失败！";
		TaoBaoAreaData taoBaoAreaData = new TaoBaoAreaData();
		try {
			out = response.getWriter();
			String ip = IPUtil.getRealIp(request);
			ip = "101.254.183.41";
			logger.info("请求地址真实ip是---------------------------------> "+ip);
//			ip = ip.substring(0, ip.lastIndexOf("."))+".0";
//			logger.info("只要获取ip的前三段就可以确定所属地信息了，此参数ip为--------> ip:"+ip);
			//查看数据库中是否有此ip
			IP ipModel = this.taoBaoAreaService.selectByPrimaryKey(ip);
			if(ipModel!=null){
				map.put("regionId", ipModel.getRegionId());
				map.put("cityId", ipModel.getCityId());
				message = "查询成功！";
			}else{
				String result = IPUtil.getAddressByIP(ip);
				if(result!=null && !"".equals(result.trim())){
					result = result.replaceAll("_id", "Id").replace("data", "taoBaoArea");
					//json转对象
					taoBaoAreaData = JSON.toJavaObject(JSON.parseObject(result), TaoBaoAreaData.class);
					if(taoBaoAreaData.getCode() == 0){
						TaoBaoArea taoBaoArea = taoBaoAreaData.getTaoBaoArea();
						if(taoBaoArea!=null){
							taoBaoArea.setId(UUID.randomUUID().toString().replaceAll("-", ""));
							if(this.taoBaoAreaService.insertTaoBaoAreaAndChildTable(taoBaoArea)==1){
								map.put("regionId", taoBaoArea.getRegionId());
								map.put("cityId", taoBaoArea.getCityId());
								message = "查询成功！";
							}
						}
					}
				}
			}
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}finally{
			if(out !=null){
				json.setSuccess(success);
				json.setObj(map);
				json.setMessage(message);
				out.print(JSON.toJSONString(json));
				out.close();
			}
		}
		return null;
	}
}