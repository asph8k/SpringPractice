<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>오늘 날씨 왜이렇게 더운 것이냐.....</h2>
	
	<form action="/basic/request/basic01">
		<input type="submit" value="GET 요청!">
	</form>
	
	<form action="/basic/request/basic01" method="post">
		<input type="submit" value="POST 요청!">
	</form>

</body>
</html>