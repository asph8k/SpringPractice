package com.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.model.BoardVO;
import com.spring.basic.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;

	//1. 사용자가 글을 작성할 수 있는 화면을 보여주는 메소드 선언 write.jsp
	@GetMapping("/write")
	public void showWirte() {
		System.out.println("/board/write: GET");
	}
	
	//2. 사용자가 게시물 작성 후 등록 버튼을 눌렀을때 DB에 등록해주는 메소드
	@PostMapping("/write")
	public String insertWrite(BoardVO vo) {
		System.out.println("/board/write: POST");
		service.insertBoard(vo);
		return "redirect:/board/list";
	}
	
	//3. 게시물을 등록하면 list.jsp 화면을 보여주는 메소드
	@GetMapping("/list")
	public void showList() {
		System.out.println("/board/list: GET");
	}
	
	//4. list.jsp 화면에 사용자가 작성한 게시물들을 화면에 뿌려주는 메소드
	
	//5. list.jsp에서 사용자가 새게시물 작성하기를 누르면 write.jsp로 돌아가는 메소드
	
	//6. 사용자가 제목을 누르면 content.jsp를 보여주는 메소드 [ 게시글 번호를 같이 가지고 간다 ]
	
	//7. content.jsp에서 글 목록보기를 누르면 다시 list.jsp의 화면을 보여주는 메소드
	
	//8. content.jsp에서 글 수정하기를 누르면 modify.jsp의 화면을 보여주는 메소드 [ 게시글 번호를 같이 가지고 간다 ]
	
	//9. modify.jsp에서 수정버튼을 누르면 content.jsp의 화면을 보여주는 메소드
	
	//10. list.jsp에서 삭제버튼을 누르면 게시물을 삭제해 주는 메소드 [ 게시글 번호도 같이 가지고 간다 ]
		
}
