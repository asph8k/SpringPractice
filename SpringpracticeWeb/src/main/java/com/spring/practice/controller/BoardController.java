package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.practice.model.BoardVO;
import com.spring.practice.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//사용자에게 게시글 등록할 수 있는 창을 보여주는 메소드
	@GetMapping("/write")
	public void showPostWindow() {
		System.out.println("/board/write: GET");
	}
	
	//사용자가 입력한 내용을 가지고 등록을 시켜주는 메소드
	@PostMapping("/write")
	public String insertPost(BoardVO vo) {
		System.out.println("/board/write: POST");
		service.insertPost(vo);
		return "redirect:/board/list";
	}
	
	//등록이 완료되면 사용자에게 글 목록창을 보여주는 메소드
	@GetMapping("/list")
	public void showPostList(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles", service.selectAllPost());
	}
	
	//사용자가 글 목록창에서 제목을 누르면 글 상세보기 창을 보여주는 메소드 [ 글 번호를 가지고 감 ]
	
	//상세보기 창에서 사용자가 글 수정을 누르면 수정페이지 화면을 보여주는 메소드 [ 글 번호를 가지고 감 ]
	
	//수정페이지에서 사용자가 수정한 내용들을 가지고 상세보기 창을 보여주는 메소드
	
	//글 목록창에서 삭제를 누르면 해당 게시물을 삭제 시켜주는 메소드 [ 글 번호를 가지고 감 ]
	
}
