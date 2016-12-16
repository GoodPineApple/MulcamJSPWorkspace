<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>이클립스 첫번째 jsp</title>
</head>
<body>
	<%
		Date now = new Date();
	%>
	이클립스에서 작성한 첫번째 jsp파일<br>
	현재시각 : <%=now%><br>
	반갑습니다.
	
</body>
</html>