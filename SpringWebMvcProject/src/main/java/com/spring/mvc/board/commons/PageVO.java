package com.spring.mvc.board.commons;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString
public class PageVO {

	private int page; //사용자가 선택한 페이지 번호
	private int cpp; //사용자가 선택한 한 화면에 보여질 게시물 개수
	
	public PageVO() {
		this.page = 1;
		this.cpp = 10;
	}
	
}
