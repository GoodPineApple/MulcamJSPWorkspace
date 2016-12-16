<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test06_b.jsp</title>
</head>
<body>
	<%
		String n = request.getParameter("name");
		System.out.println("test06_b.jsp name:" + n);
	%>
	<h1>B</h1>

</body>
</html>