<%@page import="javax.websocket.Session"%>
<%@page import="repository.BookDAO"%>
<%@page import="vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04_delete.jsp</title>
</head>
<body>
<% 
	String bookIdStr = request.getParameter("bookId");
	int bookId = 0;
	if(bookIdStr != null) {
		bookId = Integer.parseInt(bookIdStr);
	}
	
	BookVO book = new BookVO();
	BookDAO dao = new BookDAO();
	book = dao.select(bookId);
	session.setAttribute("delete", bookId);
%>
	<h2>�Ʒ� å�� �����Ͻðڽ��ϱ�?</h2>
	<table border = "2">
		<tr>
			<th>å��ȣ</th>
			<th>�̸�</th>
			<th>���ǻ�</th>
			<th>����</th>
			<th>���ǳ⵵</th>
		</tr>
		<tr>
			<td><%=book.getBookId() %></td>
			<td><%=book.getTitle() %></td>
			<td><%=book.getPublisher() %></td>
			<td><%=book.getPrice() %></td>
			<td><%=book.getYear() %></td>
		</tr>
	</table> <br>
	<a href="test04_delete_action.jsp"><button>����</button></a> <br>
	<a href="test04_index.jsp"><button>��������</button></a>
</body>
</html>