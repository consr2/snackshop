package com.home.basket.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.basket.BasketService;

@Controller
public class BasketController {

	@Autowired
	private BasketService basketService;
	
	@RequestMapping("/basket")
	public String showBasket(HttpSession session) {
		
		return "basket";
	}
	
	@RequestMapping("/basket/add/{idx}")
	public String addBasket(@PathVariable("idx")int idx, HttpSession session,
			@RequestParam("quantity")int quantity) {
		
		basketService.addBasket(idx, session, quantity);
		return "redirect:/snack/list";
	}
}
