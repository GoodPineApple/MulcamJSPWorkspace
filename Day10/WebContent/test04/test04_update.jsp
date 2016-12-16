<%@page import="vo.BookVO"%>
<%@page import="repository.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
	int bookId = 0;
	String bookIdStr = request.getParameter("bookId");
	if(bookIdStr != null) {
		bookId = Integer.parseInt(bookIdStr);
	}
	session.setAttribute("update", bookId);
%>
<h2>책 수정 내용 입력</h2>
	<form action="test04_update_action.jsp" method="post">
		제   목 : <input type="text" name="title" size="20"><br>
		출판사 : <input type="text" name="pub" size="20"><br>
		출판년도 : <input type="text" name="year" size="20"><br>
		가  격 : <input type="number" name="price" size="20"><br>
		<input type="submit" value="저장">
	</form>

</body>
</html>