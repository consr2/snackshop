package com.home.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@RequestMapping("/game")
	public String game() {
		return "game";
	}
}
