package com.home.user.impl;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.user.UserDao;
import com.home.user.UserService;
import com.home.user.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public UserVo loginProcess(HashMap<String, Object> map) {
		return userDao.loginProcess(map);
	}

	@Override
	public void singUp(HashMap<String, Object> map) {
		userDao.singUp(map);
	}
}
