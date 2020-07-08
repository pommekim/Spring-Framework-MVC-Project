package com.spring.mvc.user.test;

import java.util.List;

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
	
	@Test
	public void deleteTest() {
		String account = "abc1234";
		mapper.delete(account);
		System.out.println("회원탈퇴 성공!");
	}
	
	@Test
	public void selectOneTest() {
		String account = "abc1234";
		UserVO user = mapper.selectOne(account);
		System.out.println(user.toString());
		System.out.println("회원 개별조회 성공!");
	}
	
	@Test
	public void selectAllTest() {
		List<UserVO> list = mapper.selectAll();
		System.out.println(list.toString());
		System.out.println("회원 전체조회 성공!");
	}
	
	
	
	
	

}
