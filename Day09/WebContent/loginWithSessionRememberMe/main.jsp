<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
</head>
<body>
	<%
		if (session.getAttribute("name") == null) {
			response.sendRedirect("loginForm.jsp");
		} else {
			out.println(session.getAttribute("name") + "님 안녕하세요.");
	%>
	<h2>[로그인 완료]</h2>
	환영합니다.
	<br> 메인입니다. 아래는 로그아웃입니다.
	<br>
	<form action="loginForm.jsp" method="post">
		<input type="submit" value="로그아웃">
	</form>
	<%
		}
	%>




</body>
</html>