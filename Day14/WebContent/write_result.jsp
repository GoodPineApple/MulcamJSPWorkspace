<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write_result.jsp</title>
</head>
<body>
<%
	String writeResult = (String) request.getAttribute("writeResult");
%>
<h2>글쓰기 수행 결과 페이지</h2>
글쓰기 수행 결과 : <%=writeResult%> <br>
<a href="board.do?action=main"><button>게시판 메인으로</button></a>

</body>
</html>