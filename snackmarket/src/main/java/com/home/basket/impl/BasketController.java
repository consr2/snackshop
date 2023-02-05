package com.home.basket.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.basket.BasketAndSnackVo;
import com.home.basket.BasketService;
import com.home.user.UserService;

@Controller
public class BasketController {

	@Autowired
	private BasketService basketService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/basket")
	public String showBasket(HttpSession session,Model model) {
		int userIdx = (int) session.getAttribute("userIdx");
		List<BasketAndSnackVo> bAnds = basketService.getBasketAndSanck(userIdx);
		
		model.addAttribute("basketList", bAnds);
		
		return "/basket/basket";
	}
	
	@RequestMapping("/basket/add/{idx}")
	public String addBasket(@PathVariable("idx")int idx, HttpSession session,
			@RequestParam("quantity")int quantity) {
		
		basketService.addBasket(idx, session, quantity);
		return "redirect:/snack/list";
	}
	
	@RequestMapping("/basket/delete/{idx}")
	public String deleteBasket(@PathVariable("idx")int idx) {
		basketService.delete(idx);
		
		return "redirect:/basket";
	}
	
	
}
