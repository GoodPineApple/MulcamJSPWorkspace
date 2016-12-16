<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test06_get_attr.jsp</title>
</head>
<body>
<%
	Date settingTime = (Date)session.getAttribute("settingTime");
%>
당신이 세션에 기록한 settingTime은 다음과 같습니다.<br>
<b><%=settingTime %></b> <br>


sessionID : <%= session.getId() %>

</body>
</html>