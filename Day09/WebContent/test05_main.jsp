<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test05_main.jsp</title>
</head>
<body>
<%
	int num=100;
%>

main의 include 디렉티브 이전 내용 <br>

<%@ include file="test05_sub.jsp" %>

오늘 날짜 : <%= now %>
</body>
</html>