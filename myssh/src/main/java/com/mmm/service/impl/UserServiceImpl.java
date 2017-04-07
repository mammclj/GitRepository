package com.mmm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.dao.UserMapper;
import com.mmm.model.User;
import com.mmm.service.UserService;
import com.mmm.utils.database.DataSource;
import com.mmm.utils.database.DynamicDataSourceHolder;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public List<User> getAll() {
		logger.info("DataSource----> "+DynamicDataSourceHolder.getDataSource());
		return userMapper.getAll();
	}

	public List<User> getAll2() {
		return userMapper.getAll2();
	}

	public List<User> getAll3() {
		return userMapper.getAll3();
	}

	public void save(String name) throws Exception{
		User user = userMapper.selectByPrimaryKey("1");
		user.setModifydatetime(new Date());
		user.setName("333");
		userMapper.updateByPrimaryKeySelective(user);
		user.setName(name);
		userMapper.updateByPrimaryKeySelective(user);
		System.out.println(1/0);
	}
}
