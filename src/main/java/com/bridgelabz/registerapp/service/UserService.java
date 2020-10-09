package com.bridgelabz.registerapp.service;

import java.sql.SQLException;

import com.bridgelabz.registerapp.dao.UserDao;
import com.bridgelabz.registerapp.model.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	public boolean registerUser(User user) throws SQLException {
		return userDao.registerUser(user);
	}

}
