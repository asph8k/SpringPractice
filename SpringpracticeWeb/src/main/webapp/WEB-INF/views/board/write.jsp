<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 등록하는 곳</h2>
	
	<form method="post">
		<p>
			# 작성자: <input type="text" name="writer"><br>
			# 제목: <input type="text" name="title"><br>
			# 내용: <textarea rows="3" name="content"></textarea>
			<input type="submit" value="등록하기">
		</p>
	</form>

</body>
</html>