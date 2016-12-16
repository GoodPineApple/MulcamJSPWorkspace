<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test02_get.jsp</title>
</head>
<body>
<%
	String paramAttr = (String)session.getAttribute("paramAttr");
%>
현재 당신의 세션에 기록된 paramAttr 값 : <%=paramAttr%><br>

</body>
</html>