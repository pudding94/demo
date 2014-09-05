package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.po.User;
@Service
public class UserService {
	private UserDao userDao;
	public String save(User name){
		return null;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
