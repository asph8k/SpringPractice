package com.spring.mvc.board.service;

import java.util.List;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;

public interface IBoardService {

	//게시글 등록 기능
	void insert(BoardVO article);
		
	//게시글 전체 조회 기능(페이징 전)
	//List<BoardVO> getArticleList();
	
	//페이징 처리를 포함한 게시글 목록 조회 기능
	//List<BoardVO> getArticleList(PageVO paging);
	
	//검색 기능이 추가된 게시글 목록 조회 기능
	List<BoardVO> getArticleList(SearchVO search);
		
	//게시글 상세 조회 기능
	BoardVO getArticle(int boardNo);
		
	//게시글 수정 기능
	void update(BoardVO article);
		
	//게시글 삭제 기능
	void delete(int boardNo);
		
	//게시글 수 조회 기능
	int countArticles(SearchVO search);
	
}
