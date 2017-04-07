package com.mmm.service;

import java.util.List;

import com.mmm.model.User;
import com.mmm.utils.database.DataSource;

public interface UserService {

	public User getUserById(String id);

	@DataSource("dataSource2")
	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();
	
	void save(String name) throws Exception;

}
