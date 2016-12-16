<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL과 JSTL</title>
</head>
<body>
<c:forEach var="cnt" begin="1" end="10" varStatus="status">${cnt}
<c:if test="${not status.last}">,</c:if>
</c:forEach>
<table border="1" style="width:50%; text-align:center;">
	<tr>
		<th>index</th>
		<th>count</th>
		<th>cnt</th>
	</tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="status">
	<tr>
		<td>${status.index}</td>
		<td>${status.count}</td>
		<td>${cnt}</td>
	</tr>
	</c:forEach> <br><br>
</table>	
	
<table border="1" style="width:100%; text-align:center">
	<tr>
		<th> index </th>
		<th> count </th>
		<th> cnt </th>
	</tr>
		<c:forEach var="cnt" begin="1" end="10" varStatus="status" step="2">
	<tr>
		<td>${status.index}</td>
		<td>${status.count}</td>
		<td>${cnt}</td>
	</tr>
	</c:forEach> <br><br>
</table>
</body>
</html>