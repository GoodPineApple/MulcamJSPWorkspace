<%@page import="vo.Book"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test02.jsp</title>
</head>
<body>
<%
	Book book = (Book)request.getAttribute("book");
%>
���� : <%=book.getTitle()%><br>
���� : ${requestScope.book.title}<br>
���� : ${book.title}<br>
���� : ${book["title"]}<br>
������ 10000�� �̻��ΰ� ? ${book.price>=10000} <br>
<%-- ������ 10000���� �ƴѰ�? ${not book.price==10000}<br> --%>
����Ʈ�� ����°� ? ${empty bookList}<br>
���� + 5000 : ${book.price + 5000}<br>
�ȶ��� ���� ��� : ${"10"+5}<br>
���ڿ� �� : ${"aaa" == "aaa"} <br> <!-- equlas �޼ҵ带 ������� �ʾƵ� ���� -->
bookList�� ũ�� : ${bookList.size()} <br>
</body>
</html>