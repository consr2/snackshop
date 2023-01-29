package com.home.snack.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.snack.SnackDao;
import com.home.snack.SnackVo;

@Repository("snackDao")
public class SnackDaoImpl implements SnackDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addSnack(SnackVo snackVo) {
		sqlSession.insert("Snack.snackInsert", snackVo);
	}

	@Override
	public List<SnackVo> showList() {
		List<SnackVo> snackList = sqlSession.selectList("Snack.snackList");
		
		return snackList;
	}
}
