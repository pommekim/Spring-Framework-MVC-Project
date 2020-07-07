package com.spring.mvc.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	@Test
	public void registerTest() {
		
		UserVO user = new UserVO();
		user.setAccount("abc1234");
		user.setPassword("aaa1111");
		user.setName("박재범");
		
		mapper.register(user);
		System.out.println("회원가입 성공!");
	}
	
	
	
	
	
	
	
	
	
	

}
