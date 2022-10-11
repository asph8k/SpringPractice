package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.ScoreVO;
import com.spring.db.repository.IScoreDAO;
import com.spring.db.repository.IScoreMapper;

@Service
public class ScoreService implements IScoreService {
	
	//JdbdTemplate을 이용한 SQL처리
//	@Autowired
//	private IScoreDAO dao;
	
	//Mybatis를 이용한 SQL 처리.
	@Autowired
	private IScoreMapper mapper;

	@Override
	public void insertScore(ScoreVO score) {
		score.calcData();
		mapper.insertScore(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return mapper.selectAllScores();
	}

	@Override
	public void deleteScore(int num) {
		mapper.deleteScore(num);
	}

	@Override
	public ScoreVO selectOne(int num) {
		return mapper.selectOne(num);
	}

}
