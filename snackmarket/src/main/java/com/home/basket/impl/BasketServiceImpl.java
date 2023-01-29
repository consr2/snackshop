package com.home.basket.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.basket.BasketDao;
import com.home.basket.BasketService;

@Service("basketService")
public class BasketServiceImpl implements BasketService{

	@Autowired
	private BasketDao basketDao;

	@Override
	public void addBasket(int idx, HttpSession session) {
		basketDao.addBasket(idx, session);
	}
}
