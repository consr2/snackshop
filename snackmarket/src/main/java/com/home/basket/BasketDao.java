package com.home.basket;

import javax.servlet.http.HttpSession;

public interface BasketDao {

	void addBasket(int idx, HttpSession session);

}
