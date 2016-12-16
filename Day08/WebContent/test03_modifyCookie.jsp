<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>test03_modifyCookie.jsp</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("cookie1", "BBB");
	cookie.setMaxAge(30);
	response.addCookie(cookie);
%>
<h2>test03_modifyCookie.jsp</h2>
cookie1번을 수정해서 발급하였습니다.<br>
수명을 30초로 셋팅해 놓았습니다.
</body>
</html>