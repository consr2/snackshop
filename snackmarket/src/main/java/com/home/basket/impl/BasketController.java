package com.home.basket.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String addBasket(@PathVariable("idx")int idx, HttpSession session) {
		System.out.println(idx);
		basketService.addBasket(idx, session);
		return "redirect:/snack/list";
	}
}
