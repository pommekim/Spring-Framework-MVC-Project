package com.spring.mvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//JSON형태의 데이터를 받기 위해서는 @RequestBody가 필요!!!
	@PostMapping("/")
	public String register(@RequestBody UserVO user) {
		System.out.println("/user/ : POST 요청 발생!");
		System.out.println("param: " + user);
		
		service.register(user);
		return "joinSuccess";
	}
	
	//아이디 중복 확인 요청 처리
	@PostMapping("/checkId")
	public String checkId(@RequestBody String account) {
		System.out.println("/user/checkId : POST 요청 발생!");
		System.out.println("parameter: " + account);
		
		String result = null;
		
		int checkNum = service.checkId(account);
		if(checkNum == 1) {
			System.out.println("아이디가 중복됨!");
			result = "NO";
		} else {
			System.out.println("아이디 사용 가능!");
			result = "OK";
		}
		
		return result;
	}
	
	
	//회원 탈퇴 요청 처리
//	@RequestMapping(value="/", method=RequestMethod.DELETE)
	@DeleteMapping("/{account}")
	public String delete(@PathVariable String account) {
		System.out.println("/user/" + account + " : DELETE 요청 발생!");
		
		service.delete(account);
		return "delSuccess";
	}
	
	//회원 정보 조회 요청 처리
	@GetMapping("/{account}")
	public UserVO selectOne(@PathVariable String account) {
		System.out.println("/user/" + account + " : GET 요청 발생!");
		
		return service.selectOne(account);
	}
	
	//회원정보 전체조회 요청 처리
	@GetMapping("/")
	public List<UserVO> selectAll() {
		System.out.println("/user/ : GET 요청 발생!");
		
		return service.selectAll();
	}
	
		
	
	

}
