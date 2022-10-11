package com.spring.myweb.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor{

	//회원권한이 필요한 페이지 요청이 들어왔을 때, 요청을 가로채 확인할 인터셉터
	//글쓰기 화면과, 마이페이지 화면 들어가는 요청을 가로채 검사하도록 합시다.
	//권한이 없다면 로그인 페이지로 보내줍시다.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션에서 로그인 데이터를 얻은 후 확인을 해 줍시다.
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			//로그인 안함
			response.sendRedirect(request.getContextPath() + "/user/userLogin");
			return false; //컨트롤러 진입을 막습니다.
		}
		
		return true; //로그인 한 사람은 통과
	}
	
}
