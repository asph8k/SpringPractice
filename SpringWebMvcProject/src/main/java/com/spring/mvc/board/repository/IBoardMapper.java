package com.spring.mvc.board.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;

public interface IBoardMapper {

	//게시글 등록 기능
	void insert(BoardVO article);
	
	//게시글 전체 조회 기능(페이징 전)
	//List<BoardVO> getArticleList();
	
	//페이징 처리를 포함한 게시글 목록 조회 기능
	//List<BoardVO> getArticleList(PageVO paging);
	
	/*
	 - MyBatis로 DB연동을 진행할때 파라미터 값이 2개 이상이라면
	 그냥 보내면 에러가 발생하기 때문에 조치가 필요합니다.
	 
	 조치 방법
	 1. @Param을 이용해서 이름을 붙여주는 방법. (xml파일에서 해당 값을 지목할 수 있는 이름을 붙인다.)
	//검색 기능이 추가된 게시글 목록 조회 기능
	List<BoardVO> getArticleList(@Param("paging") PageVO paging, 
									@Param("condition") String condition, 
									@Param("keyword") String keyword);
									
	2. Map으로 포장해서 보내는 방법.
	
	//검색 기능이 추가된 게시글 목록 조회 기능
	List<BoardVO> getArticleList(Map<String, Object> data);
	
	3. 클래스를 디자인해서 객체 하나만 매개값으로 보내는 방법
	
	중 하나를 상황에 맞게 적절하게 선택하면 됩니다.
	*/
	//검색 기능이 추가된 게시글 목록 조회 기능
	List<BoardVO> getArticleList(SearchVO search);
	
	//게시글 상세 조회 기능
	BoardVO getArticle(int boardNo);
	
	//게시글 수정 기능
	void update(BoardVO article);
	
	//게시글 삭제 기능
	void delete(int boardNo);
	
	//게시글 수 조회 기능
	//에도 이제 검색 결과에 따른 게시물 수를 리턴할 수 있어야 하기 때문에
	//검색에 관련된 내용을 품고 있는 SearchVO를 매개값으로 받도록 하겠습니다.
	int countArticles(SearchVO search);
	
}
