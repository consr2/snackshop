package com.home.user.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	@Override
	public void singUpNaver(Map<String, Object> map) {
			
		UserVo user = sqlSession.selectOne("User.userLogin", map);
		
		//첫 로그인이면 저장
		if(user == null) {
			sqlSession.insert("User.userInsert", map);
		}
		
	}
}
