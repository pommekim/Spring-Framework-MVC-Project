package com.spring.mvc.user.repository;

import com.spring.mvc.user.model.UserVO;

public interface IUserMapper {
	
	//회원 가입 기능
	void register(UserVO user);

}
