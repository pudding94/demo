package com.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.po.User;
import com.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public String save(User user) {
		return this.userDao.save(user);
	}
}
