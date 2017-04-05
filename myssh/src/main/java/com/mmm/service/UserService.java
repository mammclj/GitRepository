package com.mmm.service;

import java.util.List;

import com.mmm.model.User;

public interface UserService {

	public User getUserById(String id);

	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();
	
	void save(String name) throws Exception;

}
