<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test05.jsp</title>
</head>
<body>
<h2>c:choose, c:when, c:otherwise �±� Ȱ���غ���</h2>
	<c:choose>
		<c:when test="${param.select==1}">
			�ϳ�!<br>
		</c:when>
		<c:when test="${param.select==2}">
			��!<br>
		</c:when>
		<c:otherwise>
			��! ��! �ټ�! ����! ��ȣ ��?<br>
		</c:otherwise>
	</c:choose>
</body>
</html>