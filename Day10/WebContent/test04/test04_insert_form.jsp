<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04_insert_form.jsp</title>
</head>
<body>
	<h2>å �԰� ���� �Է�</h2>
	<form action="test04_insert.jsp" method="post">
		��   �� : <input type="text" name="title" size="20"><br>
		���ǻ� : <input type="text" name="pub" size="20"><br>
		���ǳ⵵ : <input type="text" name="year" size="20"><br>
		��  �� : <input type="number" name="price" size="20"><br>
		<input type="submit" value="����">
	</form>
</body>
</html>