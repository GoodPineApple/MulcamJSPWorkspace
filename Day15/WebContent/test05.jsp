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
<h2>c:choose, c:when, c:otherwise 태그 활용해보기</h2>
	<c:choose>
		<c:when test="${param.select==1}">
			하나!<br>
		</c:when>
		<c:when test="${param.select==2}">
			둘!<br>
		</c:when>
		<c:otherwise>
			셋! 넷! 다섯! 여섯! 번호 응?<br>
		</c:otherwise>
	</c:choose>
</body>
</html>