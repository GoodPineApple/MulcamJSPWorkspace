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
			<th>책번호</th>
			<th>이름</th>
			<th>출판사</th>
			<th>가격</th>
			<th>출판년도</th>
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
	<h2>수정 실패</h2> <br>
	관리자에게 문의하세요.
	<%} %>
<a href="test04_index.jsp"><button>메인화면으로</button></a>
</body>
</html>