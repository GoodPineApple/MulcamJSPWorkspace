<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글쓰기 결과</title>
</head>
<body>
<%
	int writeResult = (int)request.getAttribute("writeResult");
%>
<h2>글쓰기 결과 : <%=writeResult %></h2>
<a href="board.do?action=main"><button>게시글 목록</button></a>
</body>
</html>