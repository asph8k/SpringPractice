package com.spring.practice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.practice.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	class BoardMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("mapRow 발동!");
			System.out.println("rowNum: " + rowNum);
			
			BoardVO vo = new BoardVO();
			vo.setBoardNum(rs.getInt("board_num"));
			vo.setWriter(rs.getString("writer"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			
			return vo;
		}
		
	}
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public void insertPost(BoardVO vo) {
		String sql = "INSERT INTO practice_board VALUES(bnum_seq.NEXTVAL,?,?,?)";
		template.update(sql, vo.getWriter(), vo.getTitle(), vo.getContent());
	}

	@Override
	public List<BoardVO> selectAllPost() {
		String sql = "SELECT * FROM practice_board";
		return template.query(sql, new BoardMapper());
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
