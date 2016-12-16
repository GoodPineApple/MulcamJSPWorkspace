<%@page import="repository.BookDAO"%>
<%@page import="vo.BookVO"%>
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
	request.setCharacterEncoding("euc-kr");

	BookVO book = new BookVO();
	BookDAO dao = new BookDAO();
	int bookId = (int) session.getAttribute("update");
	int price = 0;
	String priceStr = request.getParameter("price");
	if(priceStr != null) {
		price = Integer.parseInt(priceStr);
	}
	
	book.setBookId(bookId);
	book.setTitle(request.getParameter("title"));
	book.setPublisher(request.getParameter("pub"));	
	book.setYear(request.getParameter("year"));	
	book.setPrice(price);
	
	
	
	int result = dao.update(book);
	
	book = dao.select(bookId);
	if(result == 1) {%>
	<table border="1">
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
		
	</table>
	<%} else {%>
	<h2>���� ����</h2> <br>
	�����ڿ��� �����ϼ���.
	<%} %>
<a href="test04_index.jsp"><button>����ȭ������</button></a>
</body>
</html>