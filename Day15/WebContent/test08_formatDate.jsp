<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test08_formatDate.jsp</title>
</head>
<body>
	<c:set var="now" value="<%=new Date()%>"/>
	��¥ full :<fmt:formatDate value="${now}" type="date" dateStyle="full"/> <br>
	��¥ long :<fmt:formatDate value="${now}" type="date" dateStyle="long"/> <br>
	��¥ medium :<fmt:formatDate value="${now}" type="date" dateStyle="medium"/> <br>
	��¥ short :<fmt:formatDate value="${now}" type="date" dateStyle="short"/> <br>
	��¥ default :<fmt:formatDate value="${now}" type="date" dateStyle="default"/> <br> <hr>
	�ð� full :<fmt:formatDate value="${now}" type="time" timeStyle="full"/> <br>
	�ð� long :<fmt:formatDate value="${now}" type="time" timeStyle="long"/> <br>
	�ð� medium :<fmt:formatDate value="${now}" type="time" timeStyle="medium"/> <br>
	�ð� short :<fmt:formatDate value="${now}" type="time" timeStyle="short"/> <br>
	�ð� default :<fmt:formatDate value="${now}" type="time" timeStyle="default"/> <br> <hr>
	
	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/> <br>
	<fmt:formatDate value="${now}" pattern="z yy/mm/dd a hh:mm:ss"/> <br>

</body>
</html>