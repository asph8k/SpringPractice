package com.spring.basic.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.basic.model.ScoreVO;

//자동으로 빈 등록
@Repository
public class ScoreDAO implements IScoreDAO {
	
	//학생들의 점수 정보를 저장할 리스트를 생성(DB 대용으로 사용)
	private List<ScoreVO> scoreList = new ArrayList<>();

	@Override
	public void insertScore(ScoreVO score) {
		scoreList.add(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return scoreList;
	}

	@Override
	public void deleteScore(int num) {
		scoreList.remove(num);
	}

	@Override
	public ScoreVO selectOne(int num) {
		return scoreList.get(num);
	}

}
