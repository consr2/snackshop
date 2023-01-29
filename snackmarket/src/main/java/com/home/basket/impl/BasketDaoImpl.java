package com.home.basket.impl;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.basket.BasketDao;
import com.home.basket.BasketVo;
import com.home.user.UserVo;

@Repository("basketDao")
public class BasketDaoImpl implements BasketDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addBasket(int snackIdx, HttpSession session) {
		
		String username = (String)session.getAttribute("login");
		UserVo user = sqlSession.selectOne("User.userSelect", username);
		
		HashMap<String, Object> map = new HashMap<>(); 
		map.put("userIdx", user.getIdx());
		map.put("snackIdx", snackIdx);
		map.put("quantity", 1);
		
		//중복체크
		BasketVo basket = sqlSession.selectOne("Basket.basketCheck",map);
		
		//첫등록이면 insert, 중복이면 update
		if(basket == null) {
			sqlSession.insert("Basket.basketInsert", map);
		}else {
			sqlSession.update("Basket.basketUpdateQuantity", map);
		}
		
		
	}
	
}
