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
		<c:forEach var="article" items="???" varStatus="num">
			<tr>
				<td>???</td>
				<td>
					<a href="<c:url value='/board/content?boardNo=???'/>">???</a>
				</td>
				<td>???</td>
				<td>
					<a href="<c:url value='/board/delete?boardNo=???'/>">[삭제]</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="<c:url value='/board/write'/>">새게시물 작성하기</a>

</body>
</html>