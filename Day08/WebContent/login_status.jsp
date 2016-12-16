<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login_status.jsp</title>
</head>
<body>
<h2>[로그인 확인]</h2>
저희 홈페이지에 방문해주셔서 감사합니다. <br>
조회가능한 쿠키입니다.<br>
<hr>
<% 
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie cookie : cookies) {
			out.print("쿠키이름:"+cookie.getName()+"<br>");
			out.print("쿠키값:"+cookie.getValue()+"<br>");
			out.print("<hr>");
		}
	}
%> 
아래는 로그아웃입니다.<br>
<form action="logout.jsp">
	<input type="submit" value="로그아웃">
</form>
</body>
</html>