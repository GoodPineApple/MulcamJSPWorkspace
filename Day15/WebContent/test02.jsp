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
제목 : <%=book.getTitle()%><br>
제목 : ${requestScope.book.title}<br>
제목 : ${book.title}<br>
제목 : ${book["title"]}<br>
가격이 10000원 이상인가 ? ${book.price>=10000} <br>
<%-- 가격이 10000원이 아닌가? ${not book.price==10000}<br> --%>
리스트가 비었는가 ? ${empty bookList}<br>
가격 + 5000 : ${book.price + 5000}<br>
똑똑한 숫자 계산 : ${"10"+5}<br>
문자열 비교 : ${"aaa" == "aaa"} <br> <!-- equlas 메소드를 사용하지 않아도 비교함 -->
bookList의 크기 : ${bookList.size()} <br>
</body>
</html>