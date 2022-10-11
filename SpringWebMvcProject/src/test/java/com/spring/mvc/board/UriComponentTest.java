package com.spring.mvc.board;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentTest {

	@Test
	public void testUriComp() {
		
		//Uri를 쉽게 작성할 수 있도록 도와주는 유틸 클래스
		//UriComponentBuilder 사용하기.
		
		UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page", 3)
															  .queryParam("cpp", 10)
															  .queryParam("keyword", "하이루")
															  .queryParam("condition", "title")
															  .build();
		System.out.println("/board/list" + ucp.toUriString());
	}
	
}
