<%@page import="vo.Book"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test03.jsp</title>
</head>
<body>
<%
	String name="taemin";
	Book b = new Book("jsp", "taemin", 10000);
%>
<c:set var="n" value="<%=name%>"/>
�̸� : ${n}<br>
<c:set var="book" value="<%=b %>"/>
å���� : ${book.title}<br>
���� : ${book.writer}<br>
���� : ${book.price}<br>
</body>
</html>