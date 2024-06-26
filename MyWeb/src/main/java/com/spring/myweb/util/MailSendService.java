package com.spring.myweb.util;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {
	
	@Autowired
	private JavaMailSender mailSender;
	private int authNum;
	
	//난수 발생 (마음대로 설정해도 됨.)
	public void makeRandomNumber() {
		//난수의 범위: 111111 ~ 999999
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호: " + checkNum);
		authNum = checkNum;
	}

	//회원 가입시 사용할 이메일 양식
	public String joinEmail(String email) {
		makeRandomNumber();
		
		String setFrom = "asph7k@naver.com"; //email-config에 설정한 이메일 주소
		String toMail = email; //수신 받을 이메일
		String title = "회원 가입 인증 이메일 입니다."; //이메일 제목
		String content = "홈페이지를 방문해 주셔서 감사합니다." +
						"<br><br>" +
						"인증 번호는 " + authNum + "입니다." +
						"<br>" +
						"해당 인증 번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입.
		
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNum); //정수를 문자열로 변경해서 리턴.
	}
	
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) {
		
		try {
			MimeMessage message = mailSender.createMimeMessage(); //MimeMessage : 이미지와 html이 사용이 가능.
			//기타 설정들을 담당할 MimeMessageHelper 객체를 생성.
			//생성자의 매개값으로 Message 객체, bool, 문자 인코딩 설정
			//true 매개값을 전달하면 MutiPart 형식의 메세지 전달이 가능.
			//값을 전달하지 않으면 단순 텍스트만 사용.
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			//true -> html 형식으로 전송, 아무것도 작성하지 않으면 단순 텍스트.
			helper.setText(content, true);
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
