package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.model.BirthVO;

@Controller
@RequestMapping("/birth")
public class BirthController {

	@GetMapping("/birth-form")
	public void birth() {
		
	}
	
	@PostMapping("/add")
	public String birthAdd(@ModelAttribute("birth") BirthVO vo) {
		String birthDay = vo.getYear() + vo.getMonth() + vo.getDay();
		System.out.println("완성된 생년월일: " + birthDay);
		return "birth-result";
	}
	
}
