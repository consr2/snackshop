package com.home.snack.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.snack.SnackService;
import com.home.snack.SnackVo;

@Controller
public class SnackController {

	@Autowired
	private SnackService snackService;
	
	@RequestMapping(value="/snack/add", method= RequestMethod.GET)
	public String SnackAddForm() {
		return "snackinsert";
	}
	
	
	@RequestMapping(value="/snack/add", method= RequestMethod.POST)
	public String addSnack(SnackVo snackVo) {
		
		snackService.addSnack(snackVo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/snack/list")
	public String showList(Model model) {
		List<SnackVo> snackList = snackService.showList();
		
		model.addAttribute("snackList", snackList);
		return "snackList";
	}
}
