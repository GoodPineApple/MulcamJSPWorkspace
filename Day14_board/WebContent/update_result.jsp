<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>update_result.jsp</title>
</head>
<body>
<%
	int updateResult = (Integer) request.getAttribute("updateResult");
%>
<h2>수정하기 결과화면</h2>
결과 : <%=updateResult %> <br>

<a href="board.do?action=main"><button>게시글 목록</button></a>
</body>
</html>