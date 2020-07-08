package com.spring.mvc.user.repository;

import java.util.List;

import com.spring.mvc.user.model.UserVO;

public interface IUserMapper {
	
	//회원 가입 기능
	void register(UserVO user);
	
	//아이디 중복 체크 기능
	int checkId(String account);
	
	//회원 탈퇴 기능
	void delete(String account);
	
	//회원 개별조회 기능
	UserVO selectOne(String account);
	
	//회원 전체조회 기능
	List<UserVO> selectAll();

}
