<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test02_form.jsp</title>
</head>
<body>
	<h2>å �԰� ���� �Է�</h2>
	<form action="test02_insert.jsp" method="post">
		��   �� : <input type="text" name="title" size="20"><br>
		���ǻ� : <input type="text" name="pub" size="20"><br>
		���ǳ⵵ : <input type="text" name="year" size="20"><br>
		��  �� : <input type="number" name="price" size="20"><br>
		<input type="submit" value="����">
	</form>
</body>
</html>