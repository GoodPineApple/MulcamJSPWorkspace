<%@page import="vo.BookVO"%>
<%@page import="repository.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04.select_book.jsp</title>
</head>
<body>
<%
	String bookIdStr = request.getParameter("bookId");
	int bookId = 0;
	
	if(bookIdStr != null) {
		bookId = Integer.parseInt(bookIdStr);
	}
	
	BookDAO dao = new BookDAO();
	BookVO book = new BookVO();
	book = dao.select(bookId);
%>
	<table border="1">
		<tr>
			<td>å��ȣ</td>
			<td><%=book.getBookId() %></td>
		</tr>
		<tr>
			<td>����</td>
			<td><%=book.getTitle() %></td>
		</tr>
		<tr>
			<td>����</td>
			<td><%=book.getPrice() %></td>
		</tr>
		<tr>
			<td>���ǻ�</td>
			<td><%=book.getPublisher() %></td>
		</tr>
		<tr>
			<td>���ǳ⵵</td>
			<td><%=book.getYear() %></td>
		</tr>
	</table>

</body>
</html>