package com.home.basket;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface BasketService {

	void addBasket(int idx, HttpSession session, int quantity);

	List<BasketAndSnackVo> getBasketAndSanck(int userIdx);

	void delete(int idx);

}
