package com.jorispalmen.javaproject.dao;

import com.jorispalmen.javaproject.model.User;

import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:31
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public interface UserDao
{
	List<User> getUsers();
	User getUserById(long id);
	User getUserByEmail(String email);
	User getUserByUsername(String username);

	void insertUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
}
