package com.spring.myweb.snsboard.mapper;

import java.util.List;

import com.spring.myweb.command.SnsBoardVO;
import com.spring.myweb.command.SnsLikeVO;
import com.spring.myweb.util.PageVO;

public interface ISnsBoardMapper {

	//등록
	void insert(SnsBoardVO vo);
	
	//목록
	List<SnsBoardVO> getList(PageVO paging);
	
	//상세
	SnsBoardVO getDetail(int bno);
	
	//삭제
	void delete(int bno);
	
	//좋아요 검색
	int searchLike(SnsLikeVO vo);
	
	//좋아요 등록
	void createLike(SnsLikeVO vo);
	
	//좋아요 삭제
	void deleteLike(SnsLikeVO vo);
	
	//글 목록 요청이 들어왔을 때 게시글마다 좋아요 개수 체크
	int likeCnt(int bno);
	
	//현재 로그인 중인 사용자가 글 목록으로 왔을 때 좋아요 한 게시물 체크
	List<Integer> listLike(String userId);
}







