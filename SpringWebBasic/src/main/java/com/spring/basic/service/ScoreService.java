package com.spring.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basic.model.ScoreVO;
import com.spring.basic.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	private IScoreDAO dao;

	@Override
	public void insertScore(ScoreVO score) {
		score.calcData();
		dao.insertScore(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return dao.selectAllScores();
	}

	@Override
	public void deleteScore(int num) {
		dao.deleteScore(num - 1);
	}

	@Override
	public ScoreVO selectOne(int num) {
		return dao.selectOne(num - 1);
	}

}
