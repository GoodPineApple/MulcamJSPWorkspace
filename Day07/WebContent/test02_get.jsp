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
���� ����� ���ǿ� ��ϵ� paramAttr �� : <%=paramAttr%><br>

</body>
</html>