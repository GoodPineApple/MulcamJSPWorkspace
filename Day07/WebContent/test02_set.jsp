<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test02_set.jsp</title>
</head>
<body>
<%
	String p = request.getParameter("param");
	session.setAttribute("paramAttr", p);
%>
	����� ���� param�� ���� session�� ����Ͽ����ϴ�.<br>
</body>
</html>