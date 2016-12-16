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
<%
	String[] movieList = {"아이언맨", "닥터스트레인지", "캡아시빌워", "어벤져스"};
	// 해당 페이지에만 유효한 Context 객체
	pageContext.setAttribute("movieList", movieList);
%>
<ul>
<c:forEach var="movie" items="${movieList}" varStatus="status">
	<c:choose>
		<c:when test="${status.first}">
			<li style="front-weight: bold; color: red;">${movie}</li>
		</c:when>
		<c:otherwise>
			<li>${movie}</li>
		</c:otherwise>
	</c:choose>
</c:forEach>
</ul>

<c:forEach var="movie" items="${movieList}" varStatus="status">
		${movie} <c:if test="${not status.last}">,</c:if>
</c:forEach>
</body>
</html>