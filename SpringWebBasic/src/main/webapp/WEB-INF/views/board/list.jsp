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

	<h2>게시글 목록</h2>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>비고</th>
		</tr>
		<c:forEach var="article" items="${articles}" varStatus="num">
			<tr>
				<td>${num.index + 1}</td>
				<td>
					<a href="<c:url value='/board/content?boardNo=${num.index + 1}'/>">${article.title}</a>
				</td>
				<td>${article.writer}</td>
				<td>
					<a href="<c:url value='/board/delete?boardNo=${num.index + 1}'/>">[삭제]</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="<c:url value='/board/write'/>">새게시물 작성하기</a>

</body>
</html>