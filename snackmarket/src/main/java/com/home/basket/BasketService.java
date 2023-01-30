package com.home.basket;

import javax.servlet.http.HttpSession;

public interface BasketService {

	void addBasket(int idx, HttpSession session, int quantity);

}
