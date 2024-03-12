package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dao.imp.UserDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.dto.User;

public class UserService {
	public void saveUser(User user) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user1=userDaoImp.saveUser(user);
		if(user1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
	}
	
public User getUserById(int uid) {
	UserDaoImp userDaoImp=new UserDaoImp();
	User user1=userDaoImp.getUserById(uid);
	if(user1!=null)
	{
	return user1;
}
	else
	{
		return null;
	}
	
}

public List<User> getAllUser() {
	UserDaoImp userDaoImp=new UserDaoImp();
	List<User> users=userDaoImp.getAllUsers();
	if(users!=null)
	{
	return users;
}
	else
	{
		return null;
	}
}

public User getUserByName(String name) {
	UserDaoImp userDaoImp=new UserDaoImp();
	User user1=userDaoImp.getUserByName(name);
	if(user1!=null)
	{
	return user1;
}
	else
	{
		return null;
	}
}

public User getByRole(String role) {
	UserDaoImp userDaoImp=new UserDaoImp();
	User user1=userDaoImp.getUserByRole(role);
	if(user1!=null)
	{
	return user1;
}
	else
	{
		return null;
	}
	
}

public void deleteUserById(int uid) {
	UserDaoImp userDaoImp=new UserDaoImp();
	boolean flag=userDaoImp.deleteUserById(uid);
	if(flag)
	{
		System.out.println("Data deleted");
	}
	else
	{
		System.out.println("data not deleted");
	}
}

}