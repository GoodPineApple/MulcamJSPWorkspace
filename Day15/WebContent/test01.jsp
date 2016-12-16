<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test01.jsp</title>
</head>
<body>
<%
// 	String name = request.getParameter("name");
%>
<%-- <b><%=name%></b>´Ô ¹Ý°©½À´Ï´Ù.<br> --%>
<b>${param.name}</b>´Ô ¹Ý°©½À´Ï´Ù.<br>
</body>
</html>