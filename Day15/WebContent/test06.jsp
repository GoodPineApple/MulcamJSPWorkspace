<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test06.jsp</title>
</head>
<body>
<h2>c:forEach 태그 활용해보기</h2>
	<!-- for(int i=1; i<10; i++) -->
	<c:forEach var="i" begin="1" end="9">
		3 X ${i} = ${3*i}<br>
	</c:forEach>
	<%
		String[] words = {"aaa", "bbb", "ccc", "ddd", "eee"};
		request.setAttribute("wordsArray", words);
	%>
	<hr>
	
	<!-- for(String word : wordsArray) -->
	<c:forEach items="${wordsArray}" var="word">
		단어 : <b>${word}</b><br>
	</c:forEach>
	<hr>
	
	<hr>
	<c:forEach items="${wordsArray}" var="word" begin="2" end="4" varStatus="status">
		단어 : <b>${word}</b> index : ${status.index} / count : ${status.count}<br>
	</c:forEach>
	<hr>
</body>
</html>