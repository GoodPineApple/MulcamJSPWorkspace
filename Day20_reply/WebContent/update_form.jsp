<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ����</title>
</head>
<body>
<form action="board.do" method="post">
<input type="hidden" name="action" value="update">
<input type="hidden" name="articleNum" value="${article.articleNum}">
	<table>
		<tr>
			<td>����</td>
			<td><input type="text" name="title" size="20" placeholder="�����Է�" value = "${article.title}"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><textarea rows="20" cols="30" name="content">${article.content}</textarea>
		</tr>	
		<tr>
			<td><input type="submit" value="����"></td>
		</tr>
	</table>
</form>
</body>
</html>