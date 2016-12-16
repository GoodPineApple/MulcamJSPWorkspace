<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="repository.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04_update_form.jsp</title>
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
	</table> <br><hr>
<form action="test04_update.jsp">
	������ ��ȣ �Է� <input type="text" name="bookId"><br>
	<input type="submit" value="Ȯ��">
</form>
</body>
</html>