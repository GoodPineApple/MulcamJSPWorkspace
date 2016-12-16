<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test02_viewCookies.jsp</title>
</head>
<body>
	<h2>request에 담겨온 쿠키목록은 다음과 같습니다.</h2>
	<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie cookie: cookies) {
			out.print("쿠키이름:"+cookie.getName()+"<br>");
			out.print("쿠키값:"+cookie.getValue()+"<br>");
			out.print("<hr>");
		}
	} 
%>
</body>
</html>