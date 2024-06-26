package com.spring.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.user.service.IUserService;
import com.spring.myweb.util.MailSendService;

@Controller
@RequestMapping("/user")
public class UserController {

	/*
	Slf4j Logger
	*/
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//도로명 주소 승인키 : devU01TX0FVVEgyMDIyMDYyMjE2MTc1NTExMjcxNzA=

	@Autowired
	private IUserService service;
	
	@Autowired
	private MailSendService mailService;
	
	//회원 가입 페이지로 이동
	@GetMapping("/userJoin")
	public void userJoin() {
		System.out.println("/user/userJoing: GET");
	}
	
	//아이디 중복체크 처리(비동기)
	@ResponseBody //Rest Controller가 아닌 경우에는 아노테이션을 붙여야 비동기 통신이 가능하다.
	@PostMapping("/idCheck")
	public String idCheck(@RequestBody String id) {
		System.out.println("아이디 중복체크 요청이 들어옴!");
		int check = service.idCheck(id);
		if(check == 1) {
			return "DuplicateId";
		} else {
			return "AvailableId";
		}
	}
	
	//이메일 인증 
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청 들어옴!");
		System.out.println("인증 이메일: " + email);
		return mailService.joinEmail(email);
	}
	
	//회원 가입 요청 처리
	@PostMapping("/join")
	public String join(UserVO vo, RedirectAttributes ra) {
		System.out.println("회원 가입 요청이 들어옴!");
		System.out.println("param: " + vo);
		service.join(vo);
		ra.addFlashAttribute("msg", "joinSuccess");
		return "redirect:/user/userLogin";
	}
	
	//로그인 페이지로 이동 요청
	@GetMapping("/userLogin")
	public void userLogin() {
	}
	
	//로그인 요청
    //mapper의 login 메서드 리턴 타입이 UserVO죠?
    //그거 모델에 담으세요.
    //리턴은 /user/userLogin으로 세팅을 하세요.
    //util 패키지 안에 interceptor 패키지를 생성해서
    //UserLoginSuccessHandler 클래스를 하나 생성해 주세요.
    //UserLoginSuccessHandler는 로그인 처리 이후에 실행되는 핸들러를 
    //오버라이딩 해서 -> 모델을 꺼내오세요.
    //모덜 내의 데이터가 null인지 아닌지를 확인하셔서 
    //null이라면 로그인 실패입니다. msg라는 이름으로 loginFail을 담아서
    //userLogin.jsp 파일로 응답하도록 viewName을 세팅하시고,
    //null이 아니라면 세션 만드셔서 홈 화면으로 이동시켜 주세요.
	@PostMapping("/login")
	public String userLogin(String userId, String userPw, Model model) {
		//UserVO user = service.login(userId, userPw);
		model.addAttribute("user", service.login(userId, userPw));
		return "/user/userLogin";
	}
	
	//마이페이지 이동 요청 처리
	@GetMapping("/userMypage")
	public void userMypage(HttpSession session, Model model) {
		//세션 데이터에서 id를 뽑아야 sql문을 돌릴 수 있다.
		String id = ((UserVO) session.getAttribute("login")).getUserId();
		
		UserVO vo = service.getInfo(id);
		System.out.println("JOIN의 결과: " + vo);
		model.addAttribute("userInfo", vo);
	}
	
	//수정 로직
	@PostMapping("/userUpdate")
	public String userUpdate(UserVO vo, RedirectAttributes ra) {
		System.out.println("param: " + vo);
		service.updateUser(vo);
		ra.addFlashAttribute("msg", "수정이 완료되었습니다.");
		return "redirect:/user/userMypage";
	}
	
}
