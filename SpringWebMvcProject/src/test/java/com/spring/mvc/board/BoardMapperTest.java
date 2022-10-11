package com.spring.mvc.board;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//테스트 환경에서 Mapper 객체 활용을 위해 빈 등록 설정이 있는 xml 파일을 로딩.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {

	@Autowired
	private IBoardMapper mapper;
	
	//게시글 등록 단위 테스트
	@Test
	public void insertTest() {
		for(int i = 1; i <= 323; i++) {
			BoardVO article = new BoardVO();
			article.setTitle("테스트 제목입니다." + i);
			article.setWriter("김테스트" + i);
			article.setContent("테스트 중이니까 조용히 하세요!" + i);
			mapper.insert(article);
		}
	}
	/*
	//게시글 목록 전체 조회 테스트
	//게시물 개수 몇개인지 출력하시고, 게시글 모든 내용을 toString()으로 출력하세요.
	@Test
	public void getListTest() {
		List<BoardVO> list = mapper.getArticleList();
		System.out.println("게시물 개수: " + list.size());
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	*/
	//게시글 단일 조회 테스트
	//44번글을 조회해서 글 상세 내용을 출력해 주세요.
	@Test
	public void getArticleTest() {
		BoardVO vo = mapper.getArticle(44);
		System.out.println(vo);
	}
	
	//게시글 수정 테스트
	//BoardVO 객체를 하나 생성하시고, VO의 setter를 사용하여
	//수정 내용(글 제목, 글 내용)을 입력하고 수정을 진행해 보세요. (1번글의 제목, 내용)
	@Test
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(1);
		vo.setTitle("수정된 제목");
		vo.setContent("수정입니다");
		mapper.update(vo);
		System.out.println("수정 후 정보: " + mapper.getArticle(1));
	}

	//게시글 삭제 테스트
	//3번글을 삭제하세요. 삭제 후 상세보기를 통해 3번글을 가져왔을 때 null이 리턴되는지
	//조건문으로 확인해서 결과를 출력하세요. (null이 왔다는것 -> 삭제 성공! 게시글 없음!)
	@Test
	public void deleteTest() {
		mapper.delete(3);
		if(mapper.getArticle(3) == null) {
			System.out.println("삭제 성공! 게시물 없음!");
		} else {
			System.out.println("삭제 실패");
		}
	}

}
