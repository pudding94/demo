package com.demo.dao;

import com.demo.po.User;

public interface UserDao {
	public int addUser(User user);

	public User getUser(int id);

}
