<%@page import="vo.BookVO"%>
<%@page import="repository.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04_insert.jsp</title>
</head>
<body>
<%
	// Ŭ���̾�Ʈ�� ���� �Ķ���� �޴� �κ�
	request.setCharacterEncoding("EUC-KR"); //�ѱ��Ķ���� ó��

	String title = request.getParameter("title");
	String publisher = request.getParameter("pub");
	String year = request.getParameter("year");
	String priceStr = request.getParameter("price");
	int price = 0;

	if(priceStr != null) {
		price = Integer.parseInt(priceStr);
	}
////////////////////////////////////////////////////////////////////////////
	BookDAO dao = new BookDAO();
	int result = dao.insert(new BookVO(title,publisher,year,price));
%>
	�Է� ��� : <%=result %> <br>
	
	<a href="test04_index.jsp"><button>����ȭ������</button></a>

</body>
</html>