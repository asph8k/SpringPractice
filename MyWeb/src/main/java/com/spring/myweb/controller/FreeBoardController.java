package com.spring.myweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.service.IFreeBoardService;
import com.spring.myweb.util.PageCreator;
import com.spring.myweb.util.PageVO;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

	@Autowired
	private IFreeBoardService service;
	
	//글 등록 화면 
	@GetMapping("/freeRegist")
	public void freeRegist() {
		System.out.println("/freeBoard/freeRegist: GET");
	}
	
	//글 등록
	@PostMapping("/freeRegist")
	public String freeRegist(FreeBoardVO vo, RedirectAttributes ra) {
		System.out.println("/freeBoard/freeRegist: POST");
		service.regist(vo);
		ra.addFlashAttribute("msg", "정상 등록 처리되었습니다.");
		return "redirect:/freeBoard/freeList";
	}
	
	//목록 화면
	@GetMapping("/freeList")
	public void freeList(Model model, PageVO vo) {
		System.out.println("/freeBoard/freeList: GET");
		System.out.println(vo);
		
		PageCreator pc = new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(service.getTotal(vo));
		System.out.println(pc);
		
		model.addAttribute("boardList", service.getList(vo));
		model.addAttribute("pc", pc);
	}
	
	//글 상세보기 처리
	@GetMapping("/freeDetail/{bno}")
	public String getContent(@PathVariable int bno, @ModelAttribute("p") PageVO vo, Model model) {
		model.addAttribute("article", service.getContent(bno));
		return "freeBoard/freeDetail";
	}
	
	//글 수정 페이지 이동 처리
	@GetMapping("/freeModify")
	public void freeModify(int bno, Model model) {
		System.out.println("/freeBoard/freeModify: GET");
		model.addAttribute("article", service.getContent(bno));
	}
	
	//글 수정 처리
	@PostMapping("/freeUpdate")
	public String freeModify(FreeBoardVO vo, RedirectAttributes ra) {
		service.update(vo);
		ra.addFlashAttribute("msg", "updateSuccess");
		return "redirect:/freeBoard/freeDetail/" + vo.getBno();
	}
	
	//글 삭제 처리
	@PostMapping("/freeDelete")
	public String delete(int bno, RedirectAttributes ra) {
		service.delete(bno);
		ra.addFlashAttribute("msg", "게시글이 정상적으로 삭제되었습니다.");
		return "redirect:/freeBoard/freeList";
	}
	
}
