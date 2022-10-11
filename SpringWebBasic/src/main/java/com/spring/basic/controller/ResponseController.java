package com.spring.basic.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.basic.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	/*
	//1. Model객체를 사용하여 화면에 데이터를 전송하기.
	@GetMapping("/test")
	public void test(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age); //데이터 이름 정해준 후 데이터를 담아준다
		model.addAttribute("nick", "멍멍이");
	}
	*/
	
	//2. @ModelAttribute를 사용한 화면에 데이터 전송 처리
	//@requestParam + model.addAttribute를 합쳐놓은 것처럼 동작
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, Model model) { //파라미터값을 가져와서 age란 이름으로 담는다.
		model.addAttribute("nick", "야옹이");
		//model.addAttribute("age", age); //할 필요는 없다. X
	}
	
	@GetMapping("/test2")
	public void test2(@ModelAttribute("info") UserVO vo) { //사용자가 입력한 데이터를 info에 담는다.
		System.out.println("메소드 내의 콘솔 출력: " + vo);
	}
	
	//3. ModelAndView 객체를 활용한 처리
	//ModelAndView : 모델 생성은 물론 사용자에게 보여줄 view또한 가지고 있다. 사용자가에게 보여줄 뷰를 객체내에서 바로 지정이 가능
	@GetMapping("/test3")
	public ModelAndView test3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", "김철수");
		mv.addObject("userAge", 30);
		mv.setViewName("/response/test3");
		
		return mv;
	}
	
	////////////////////////////////////////////////////
	
	/*
	//문제 내 방식
	@GetMapping("/res-quiz01")
	public void logIn() {

	}
	 
	@PostMapping("/login")
	//@ModelAttribute("userId")는 파라미터 변수명을 가져와 모델에 바로 넣음. String id는 메소드 안에서 사용하기 위한 변수명
	public String login(@ModelAttribute("userId") String id, @RequestParam("userPw") String pw) {
		if(id.equals("kim123") && pw.equals("1234")) {
			return "response/res-quiz02";
		} else {
			return "response/res-quiz03";
		}
	}
	*/
	
	//강사님 방식
	//커맨드 객체와 Model을 사용한 방식
	/*
	@PostMapping("/login")
	public String resLogin(UserVO vo, Model model) {
		String id = vo.getUserId();
		String pw = vo.getUserPw();
		
		model.addAttribute("userId", id);
		
		if(id.equals("kim123") && pw.equals("1234")) {
			return "response/res-quiz02";
		} else {
			return "response/res-quiz03";
		}
	}
	*/
	
	//////////////////////////////////////////////////
	
	//Redirect 처리
	
	//폼 화면을 보여주는 메소드
	@GetMapping("/login")
	public String login() {
		System.out.println("/login: GET요청 발생!");
		return "response/res-redirect-form";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userId") String id, @RequestParam("userPw") String pw, @RequestParam("userPwChk") String pwChk, RedirectAttributes ra) {
		System.out.println("/login: POST 요청 발생!");
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		System.out.println("CHK: " + pwChk);
		
		if(id.equals("")) {
			//redirect 상황에서 model 객체를 사용하게 되면
			//model 내부의 데이터가 재요청이 들어올때 파라미터 값으로 붙어서 들어옵니다.
			//데이터가 url 주소 뒤에 ?와 함께 노출되어 전달됩니다.
			//model.addAttribute("msg", "아이디는 필수값이에요!");
			
			//redirect 상황에서 일회성으로 데이터를 전송할때 사용하는 메소드.
			//url 뒤에 데이터가 붙지 않습니다. 한번 이용 후 에는 알아서 소멸합니다.
			ra.addFlashAttribute("msg", "아이디는 필수값이에요!");
			return "redirect:/response/login"; //redirect:/ 요청을 다시 받을 url 지목
		} else if(!pw.equals(pwChk)){
			ra.addFlashAttribute("msg", "비밀번호 확인락을 체크하세요!");
			return "redirect:/response/login";
		} else {
			return null;
		}
		
	}
	
}
