<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSP</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
Cookie ck[] = request.getCookies();

if(cookies != null) {
	for(Cookie cookie : ck) {
		if(cookie.getName().equals("KimTaemin")) {
			out.print(cookie.getValue());
		}
	}
	%>
	님 안녕하세요!<br>
	저희 홈페이지에 방문해 주셔서 감사합니다.<br>
	즐거운 시간 되세요.....<br>
	<form method="post" action="logout.jsp">
		<input type="submit" value="로그아웃">
	</form>
<% 
} else {
%>
	<h2> 로그인에 실패했습니다.</h2>
	<p><a href="loginForm.jsp"> 되돌아가기 </a>
<% 
}
%>
</body>
</html>