package com.home.basket.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.basket.BasketAndSnackVo;
import com.home.basket.BasketDao;
import com.home.basket.BasketService;

@Service("basketService")
public class BasketServiceImpl implements BasketService{

	@Autowired
	private BasketDao basketDao;


	@Override
	public void addBasket(int idx, HttpSession session, int quantity) {
		basketDao.addBasket(idx, session, quantity);
		
	}


	@Override
	public List<BasketAndSnackVo> getBasketAndSanck(int userIdx) {
		List<BasketAndSnackVo> bAnds = basketDao.getBasketAndSanck(userIdx);
		return bAnds;
	}


	@Override
	public void delete(int idx) {
		basketDao.delete(idx);
	}
}
