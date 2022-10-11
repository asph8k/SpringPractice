package com.spring.practice.repository;

import java.util.List;

import com.spring.practice.model.BoardVO;

public interface IBoardDAO {

	//게시물을 등록해주는 메소드
	void insertPost(BoardVO vo);
	
	//전체 게시물 조회하는 메소드
	List<BoardVO> selectAllPost();
	
	//해당 게시글 상세 보기 메소드
	BoardVO selectOnePost(int num, BoardVO vo);
	
	//게시물을 수정하는 메소드
	void UpdatePost(int num);
	
	//게시물을 삭제하는 메소드
	void DeletePost(int num);
	
}
