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
	당신이 보낸 param의 값을 session에 기록하였습니다.<br>
</body>
</html>