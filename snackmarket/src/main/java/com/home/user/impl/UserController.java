package com.home.user.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.naver.NaverLoginBO;
import com.home.user.UserService;
import com.home.user.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginProcess(@RequestParam HashMap<String, Object> map,
			HttpSession session) {
		
		//현재 로그인 상태면 비활성화시킴
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		//db에서 비교
		UserVo user = userService.loginProcess(map);
		
		//로그인 로직
		if(user == null) {
			System.out.println("로그인 정보 오류");
		}else {
			System.out.println("로그인 성공");
			session.setAttribute("login", user.getUsername());
			session.setAttribute("userIdx", user.getIdx());
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String signUpForm(@RequestParam HashMap<String, Object> map) {
		return "/user/signUpForm";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String signUp(@RequestParam HashMap<String, Object> map) {
		userService.singUp(map);
		return "redirect:/";
	}
	
	
	@RequestMapping("/login/naver")
	public String naverLoginApi() {
		NaverLoginBO naver = new NaverLoginBO();
		
		return "redirect:" + naver.getApiURL();
	}
	
	@RequestMapping("/login/napi")
	public String naverLoginApiCallBack(@RequestParam("code")String code, 
			@RequestParam("state")String state, HttpSession session) throws IOException {
		NaverLoginBO naver = new NaverLoginBO();
		
		String token = naver.getToken(code, state);
		
		String info = naver.getUserInfo(token);
		
		//네이버 유저 db 저장
		HashMap<String, Object> NaverMap = (HashMap<String, Object>) new ObjectMapper().readValue(info, HashMap.class).get("response");
		HashMap<String, Object> map = new HashMap<>();
		map.put("username", NaverMap.get("name"));
		map.put("password", NaverMap.get("id"));
		
		userService.singUpNaver(map);
		UserVo user = userService.loginProcess(map);
		session.setAttribute("login", user.getUsername());
		session.setAttribute("userIdx", user.getIdx());
		
		return "redirect:/";
	}
	

	
}
