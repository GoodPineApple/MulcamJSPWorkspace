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
cookie1���� �����ؼ� �߱��Ͽ����ϴ�.<br>
������ 30�ʷ� ������ ���ҽ��ϴ�.
</body>
</html>