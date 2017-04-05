package com.mmm.dao;

import java.util.List;

import com.mmm.model.User;
import com.mmm.utils.database.DataSource;

public interface UserMapper {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);
	@DataSource("dataSource2")
	User selectByPrimaryKey(String id);
	
	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();
}