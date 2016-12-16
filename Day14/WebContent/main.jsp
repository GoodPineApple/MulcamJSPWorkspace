<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
</head>
<body>
<%
	String articlePage = (String)request.getAttribute("articlePage");
%>
<h2>이곳은 메인 화면입니다.</h2>
자바 서블릿에서 넘겨받은 결과데이터 : <%=articlePage%> <br>

<a href="board.do?action=writeForm"><button>글쓰기</button></a>
</body>
</html>