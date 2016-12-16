<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="repository.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04_select_list.jsp</title>
</head>
<body>
<%
	BookDAO dao = new BookDAO();
	List<BookVO> booklist = dao.selectTotalList();
%>

	<table border="2">
		<tr>
			<th>å��ȣ</th>
			<th>����</th>
			<th>���ǻ�</th>
			<th>����</th>
			<th>���ǳ⵵</th>
		</tr>
		<%for(BookVO b : booklist) {%>
		<tr>
			<td><%=b.getBookId() %></td>
			<td><%=b.getTitle() %></td>
			<td><%=b.getPublisher() %></td>
			<td><%=b.getPrice() %></td>
			<td><%=b.getYear() %></td>
		</tr>
		<%}%>
	</table> <br>
	
	<a href="test04_index.jsp"><button>����ȭ������</button></a>
</body>
</html>