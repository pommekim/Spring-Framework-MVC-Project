package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list = service.getArticleList();
		System.out.println("URL: /board/list GET -> result: " + list.size());
		model.addAttribute("articles", list);
		return "board/list";
	}
	
	//게시글 작성 페이지 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("URL: /board/write -> GET");
	}
	
	//게시글 DB 등록 요청
	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes ra) {
		System.out.println("URL: /board/write -> POST");
		System.out.println("Controller parameter: " + article);
		
		service.insert(article);
		ra.addFlashAttribute("message", "insertSuccess");
		return "redirect:/board/list";
	}
	
	
	
	
	
	
	
	
	

}
