<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>confirmPassword</title>
</head>
<body>
<h2>��й�ȣ�� �Է��Ͻʽÿ�</h2>
<form action="board.do">
	<c:choose>
		<c:when test="${type=='delete'}">
			<input type="hidden" name="type" value="delete">
		</c:when>
		<c:otherwise>
			<input type="hidden" name="type" value="update">
		</c:otherwise>
	</c:choose>
	<input type="hidden" name="articleId" value="${articleId}">
	<input type="hidden" name="action" value="confirmPassword">
��й�ȣ : <input type="password" name="password" size="20" placeholder="***********" ><br>
<input type="submit" value="Ȯ��">
</form>
</body>
</html>