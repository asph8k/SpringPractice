package com.spring.basic.service;

import java.util.List;

import com.spring.basic.model.BoardVO;

public interface IBoardService {

	//게시물을 등록해주는 메소드
	void insertBoard(BoardVO vo);
		
	//게시물 전체를 보여주는 메소드
	List<BoardVO> selectAllBoard();
		
	//게시물 상세보기 메소드
	BoardVO selectOneBoard(int bId);
		
	//게시물 수정 메소드
	void updateBoard(int bId, BoardVO vo);
		
	//게시물 삭제 메소드
	void deleteBoard(int bId);
	
}
