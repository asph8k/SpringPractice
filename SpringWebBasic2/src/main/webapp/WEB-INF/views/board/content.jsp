<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>???번 게시물 내용</h2>

	<p>
		# 작성자: ???<br>
		# 제목: ???<br>
		# 내용: <textarea row="5" readonly>???</textarea>
	</p>
	
	<a href="<c:url value='/board/list'/>">글 목록 보기</a>
	<a href="<c:url value='/board/modify?boardNo=???'/>">글 수정 하기</a>

</body>
</html>