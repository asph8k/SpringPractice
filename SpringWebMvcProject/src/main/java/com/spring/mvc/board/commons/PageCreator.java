package com.spring.mvc.board.commons;

import lombok.Setter;
import lombok.ToString;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;

//페이지 알고리즘에 의해 이전, 다음 버튼 및 페이지 버튼 개수 및 번호를 관장할 객체.
@Getter
@Setter
@ToString
public class PageCreator {

	private PageVO paging; //사용자가 선택한 페이지 정보를 갖고 있는 객체.
	private int articleTotalCount; //총 게시물의 수
	private int beginPage; //시작페이지 번호
	private int endPage; //끝 페이지 번호
	private boolean prev; //이전 버튼
	private boolean next; //다음 버튼
	
	//한 화면에 보여질 페이지 버튼 개수
	private final int displayPageNum = 10;
	
	//URI 파라미터를 쉽게 만들어 주는 유틸 메소드
	public String makeURI(int page) {
		UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page", page)
															  .queryParam("cpp", paging.getCpp())
															  .queryParam("keyword", ((SearchVO)paging).getKeyword())
															  .queryParam("condition", ((SearchVO)paging).getCondition())
															  .build();
		return ucp.toUriString();
	}
	
	//페이징 알고리즘을 수행할 메소드 선언
	private void calcDataOfPage() {
		
		endPage = (int) Math.ceil(paging.getPage() / (double)displayPageNum) * displayPageNum;
		
		beginPage = (endPage - displayPageNum) + 1;
		
		prev = (beginPage == 1) ? false : true;
		
		next = (endPage * paging.getCpp()) >= articleTotalCount ? false : true;
		
		if(!next) {
			endPage = (int) Math.ceil(articleTotalCount / (double)paging.getCpp());
		}
		
	}
	
	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}
	
}
