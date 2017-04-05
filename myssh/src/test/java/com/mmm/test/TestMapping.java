package com.mmm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.mmm.model.User;
import com.mmm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMapping {

	private static final Logger logger = Logger.getLogger(TestMapping.class);

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		User u = userService.getUserById("1");
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test2() {
		List<User> l = userService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test3() {
		List<User> l = userService.getAll2();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test4() {
		List<User> l = userService.getAll3();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test5(){
		try {
			this.userService.save("test111");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
