package com.home.user.impl;

import java.util.HashMap;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.user.UserDao;
import com.home.user.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVo loginProcess(HashMap<String, Object> map) {
		UserVo user = sqlSession.selectOne("User.userLogin", map);
		return user;
	}

	@Override
	public void singUp(HashMap<String, Object> map) {
		sqlSession.insert("User.userInsert", map);
		
	}
}
