<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test07.jsp</title>
</head>
<body>
<%
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	Date time = new Date();
%>
세션 ID : <%= session.getId() %><br>
<!--  ------------------------------------------------ -->
<%
	time.setTime(session.getCreationTime());
%>
> <br>
세션생성시간 : <%= formatter.format(time) %><br>
<!-- ------------------------------------------------- -->
<%
	time.setTime(session.getLastAccessedTime());
%>
이전에 마지막으로 접근한 시간 : <%= formatter.format(time) %>


</body>
</html>