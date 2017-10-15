package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.NoticesDAO;
import com.spring.web.dao.User;
import com.spring.web.dao.UsersDao;
import com.spring.web.dao.Notice;

@Service
public class UsersService {

	private UsersDao usersDao;

	
	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public void create(User user) {
		usersDao.create(user);
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

}
