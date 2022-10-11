<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 화면을 보기 위한 요청과 action의 요청이 똑같을때는 action을 작성하지 않아도 되지만 전송방식은 달라야 한다. -->
	
	<!-- 
		form태그의 action을 작성하지 않으면
		마지막 요청(현재 화면을 보기 위해 요청한 url 주소)
		url과 동일하게 서버로 요청이 들어갑니다.
	 -->
		
	<form method="post">
      <p>
         # ID: <input type="text" name="userId" size="10"> <br>
         # 비밀번호: <input type="password" name="userPw" size="10"> <br>
         # 비밀번호 확인: <input type="password" name="userPwChk" size="10"> <br>
         <input type="submit" value="로그인">
      </p>
   </form>
   
   <p style="color: red;">
   		${msg}
   </p>

</body>
</html>