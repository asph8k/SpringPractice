package com.spring.mvc.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestControllerTest {
	
	/*
	 @ResponseBody
	 - 메소드가 리턴하는 데이터를 viewResolver에게 전달하지 않고
	 클라이언트에게 해당 데이터를 바로 응답하게 합니다.
	 그렇기 때문에 비동기 통신에서 주로 많이 사용합니다.
	 - @RestController를 사용하면 모든 메소드에
	 @ResponseBody를 붙인 결과와 같습니다.
	*/
	
	@GetMapping("/hello")
	//@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/hobby")
	//@ResponseBody
	public List<String> hobby() {
		List<String> hobby = Arrays.asList("축구", "영화감상", "수영");
		return hobby;
	}
	
	@GetMapping("/study")
	public Map<String, Object> study() {
		Map<String, Object> subject = new HashMap<>();
		subject.put("자바", "java");
		subject.put("jsp", "java server pages");
		subject.put("스프링", "spring framework5");
		
		return subject;
	}
	
	@GetMapping("/person")
	public Person person() {
		Person p = new Person();
		p.setName("김철수");
		p.setAge(30);
		p.setHobby(Arrays.asList("수영", "축구", "독서"));
		return p;
	}
	
	//@RequestBody
	//클라이언트 쪽에서 전송하는 JSON 데이터를
	//서버에서 사용하는 자바 언어에 맞게 변환하여 받을 수 있게 해주는 아노테이션.
	@PostMapping("/getObject")
	public Person getObject(@RequestBody Person person) {
		System.out.println("/getObject 요청이 들어옴!");
		System.out.println("이름: " + person.getName());
		System.out.println("나이: " + person.getAge());
		System.out.println("취미: " + person.getHobby());
		
		person.setAge(26);
		
		return person;
	}
	
	@GetMapping("/getPath/{id}/{cpp}/{page}")
	public Map<String, Object> getPath(@PathVariable String id,
										@PathVariable int cpp,
										@PathVariable int page) {
		Map<String, Object> map = new HashMap<>();
		map.put("아이디", id);
		map.put("게시물 개수", cpp);
		map.put("페이지 번호", page);
		return map;
	}
	
}
