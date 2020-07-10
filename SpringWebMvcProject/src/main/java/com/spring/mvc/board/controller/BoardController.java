package com.spring.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;
import com.spring.mvc.commons.PageCreator;
import com.spring.mvc.commons.PageVO;
import com.spring.mvc.commons.SearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	/*
	//게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list = service.getArticleList();
		System.out.println("URL: /board/list GET -> result: " + list.size());
		model.addAttribute("articles", list);
		return "board/list";
	}
	*/

	/*
	//페이징 처리 이후 게시글 목록 불러오기 요청.
	@GetMapping("/list")
	public String list(Model model, PageVO paging) {
		List<BoardVO> list = service.getArticleListPaging(paging);
		
		System.out.println("URL: /board/list GET -> result: " + list.size());
		System.out.println("parameter(페이지 번호): " + paging);
		
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles());
		//System.out.println(pc);
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	}
	*/
	
	//검색 처리 이후 게시물 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model, SearchVO search) {
		
		String condition = search.getCondition();
		
		System.out.println("URL: /board/list GET -> result: ");
		System.out.println("parameter(페이지 번호): " + search);
		System.out.println("검색 조건: " + search.getCondition());
		System.out.println("검색어: " + search.getKeyword());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		List<BoardVO> list = service.getArticleList(search);
		pc.setArticleTotalCount(service.countArticles(search));
		
		/*
		if(condition.equals("title")) {
			list = service.getArticleListByTitle(search);
			pc.setArticleTotalCount(service.countArticlesByTitle(search));
		} else if(condition.equals("writer")) {
			list = service.getArticleListByWriter(search);
			pc.setArticleTotalCount(service.countArticlesByWriter(search));
		} else {
			list = service.getArticleListPaging(search);
			pc.setArticleTotalCount(service.countArticles());
		}
		*/
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	}
	
	//게시글 작성 페이지 요청
	@GetMapping("/write")
	public String write(HttpSession session, RedirectAttributes ra) {
		System.out.println("URL: /board/write -> GET");
		
//		if(session.getAttribute("login") == null) {
//			ra.addFlashAttribute("msg", "not-login");
//			return "redirect:/";
//		}
		
		return "board/write";
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
	
	//글 상세보기 요청
	@GetMapping("/content/{boardNo}")
	public String content(@PathVariable int boardNo, Model model, @ModelAttribute("p") SearchVO paging) {
		System.out.println("URL: /board/content -> GET");
		System.out.println("parameter(글 번호): " + boardNo);
		
		BoardVO vo = service.getArticle(boardNo);
		System.out.println("Result Data: " + vo);
		model.addAttribute("article", vo);
		return "board/content";
	}
	
	//게시물 삭제 처리 요청
	@PostMapping("/delete")
	public String delete(int boardNo, RedirectAttributes ra, PageVO paging) {
		System.out.println("URL: /board/delete -> POST");
		System.out.println("parameter(글 번호): " + boardNo);
		
		service.delete(boardNo);
		
		//리턴타입에 ra타입이 그대로 오기 때문에 메서드 체이닝을 통해 이어서 쓸 수 있음!!!
		ra.addFlashAttribute("message", "deleteSuccess")
		.addAttribute("page", paging.getPage())
		.addAttribute("countPerPage", paging.getCountPerPage());
		
		return "redirect:/board/list";
	}
	
	//게시물 수정 페이지 요청
	@GetMapping("/modify")
	public String modify(int boardNo, Model model, @ModelAttribute("p") PageVO paging) {
		System.out.println("URL: /board/modify -> GET");
		System.out.println("parameter(글 번호): " + boardNo);
		
		BoardVO vo = service.getArticle(boardNo);
		System.out.println("Result Data: " + vo);
		model.addAttribute("article", vo);
		return "board/modify";
	}
	
	//게시물 수정 처리 요청
	@PostMapping("/modify")
	public String modify(BoardVO article, RedirectAttributes ra) {
		System.out.println("URL: /board/modify -> POST");
		System.out.println("parameter(게시글): " + article);
		
		service.update(article);
		ra.addFlashAttribute("message", "modifySuccess");
		return "redirect:/board/content/" + article.getBoardNo();
	}

	

}
