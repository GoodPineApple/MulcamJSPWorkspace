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
<%-- <b><%=name%></b>�� �ݰ����ϴ�.<br> --%>
<b>${param.name}</b>�� �ݰ����ϴ�.<br>
</body>
</html>