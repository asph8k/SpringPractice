package com.spring.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.model.BoardVO;
import com.spring.practice.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDAO dao;

	@Override
	public void insertPost(BoardVO vo) {
		dao.insertPost(vo);
	}

	@Override
	public List<BoardVO> selectAllPost() {
		return dao.selectAllPost();
	}

	@Override
	public BoardVO selectOnePost(int num, BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdatePost(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeletePost(int num) {
		// TODO Auto-generated method stub

	}

}
