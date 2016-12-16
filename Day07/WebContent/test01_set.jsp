<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test01_set.jsp</title>
</head>
<body>
<%
	application.setAttribute("attr1", new Date());
	application.setAttribute("attr2", "Yangyu");
%>
현재 서블릿은 요청을 받았을 때<br>
application 기본 객체에 attr1, attr2 두개의 속성을<br>
등록 하였습니다.<br>

</body>
</html>