package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.User;
import com.ty.hospitalapp.service.UserService;

public class TestSaveUser {
public static void main(String[] args) {
	User user= new User();
	UserService userService= new UserService();
	
	user.setName("Ivan");
	user.setEmail("ivanadmin@gmail.com");
	user.setPhno(7025488509l);
	user.setPassword("1230");
	user.setRole("admin");
	
	userService.saveUser(user);
}
}
