package com.spring.myweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.ReplyVO;
import com.spring.myweb.reply.service.IReplyService;
import com.spring.myweb.util.PageVO;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private IReplyService service;
	
	//댓글 등록
	@PostMapping("/replyRegist")
	public String regist(@RequestBody ReplyVO vo) { //@RequestBody : JSON에서 넘어오는 데이터를 자바언어에 맞게 변환.
		System.out.println("댓글 등록 요청이 들어옴!");
		service.replyRegist(vo);
		return "regSuccess";
	}
	
	//페이징이 추가된 댓글 목록을 불러오는 요청
	@GetMapping("/getList/{bno}/{pageNum}")
	public Map<String, Object> getList(@PathVariable int bno,@PathVariable int pageNum) { //List,Model를 사용할 수 없기 때문에 Map으로 하나로 묶어서 사용.
		//1. getList 메소드가 (글번호, 페이지번호)를 매개값으로 받습니다.
		//2. Mapper 인터페이스에 각각 다른 값을 전달하기 위해 Map을 쓰던지, @Param 아노테이션을 사용.
		//3. ReplyMapper.xml에 sql문을 페이징 쿼리로 작성합니다.
		//4. 레스트 방식은 화면에 필요한 값을 여러개 보낼때, 리턴데 Map이나 VO형식으로 필요한 데이터를 한번에 담아서 처리.
		//댓글 목록 리스트와 전체 댓글 개수를 함께 전달한 예정.
		PageVO vo = new PageVO();
		vo.setPageNum(pageNum); //화면에서 전달된 페이지 번호
		vo.setCpp(5); //댓글은 한 화면에 5개씩.
		
		List<ReplyVO> list = service.getList(vo, bno); //댓글 목록 데이터
		int total = service.getTotal(bno); //전체 댓글 개수
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", total);
		return map;
	}
	
	//댓글 수정 요청
	@PostMapping("/update")
	public String update(@RequestBody ReplyVO vo) {
		System.out.println("댓글 수정 요청이 들어옴!");
		int result = service.pwCheck(vo);
		/*
		if(vo.getReplyPw().equals(service.pwCheck(vo))) {
			service.update(vo);
		}
		*/
		if(result == 1) { //비밀번호가 맞는 경우
			service.update(vo);
			return "modSuccess";
		} else {
			return "pwFail";
		}
	}
	
	//댓글 삭제 요청
	@PostMapping("/delete")
	public String delete(@RequestBody ReplyVO vo) {
		System.out.println("댓글 삭제 요청이 들어옴!");
		int data = service.pwCheck(vo);
		if(data == 1) {
			service.delete(vo.getRno());
			return "deleteSuccess";
		} else {
			return "passwordFail";
		}
	}
}
