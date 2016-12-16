<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@	page errorPage="test06_error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test06.jsp</title>
</head>
<body>
<% 

String name = request.getParameter("name").toUpperCase();

%>

<%= name %> 님 반갑습니다.
이 페이지는 name파라미터가 없는 경우 에러가 발생하는 페이지입니다.<br>

</body>
</html>