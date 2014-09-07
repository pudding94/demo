package com.demo.service;

import com.demo.po.User;

public interface UserService {
	public int addUser(User user);

	public User getUser(int id);
}
