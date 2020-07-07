package com.spring.mvc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	//회원 가입 요청 처리
	//Rest-api에서 Insert -> Post
	@PostMapping("/")
	public String register(UserVO user) {
		System.out.println("/user/ POST 요청 발생!");
		System.out.println("param: " + user);
		
		service.register(user);
		return "joinSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
