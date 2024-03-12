package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.User;

public interface UserDao {
	public User saveUser(User user);

	public User getUserById(int uid);
	
	public List<User> getAllUsers();
	
	public User getUserByName(String name);
	
	public User getUserByRole(String role);

	public boolean deleteUserById(int uid);

	public User updateUserById(int uid,User user);
	
}
