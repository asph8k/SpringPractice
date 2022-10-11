package com.spring.mvc.board.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//아노테이션으로 선언만 해주면 간단하게 getter,setter등을 자동으로 구현된다.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardVO {

	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Timestamp regDate;
	private int viewCnt;	
	
	//new 마크 부착 여부 논리 타입 필드
	private boolean newMark;
	
}
