<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>���� ������ִ� JSP</title>
</head>
<body>
	<h2>JSP ������ ����� �ִ� html ȭ���Դϴ�.Get</h2>
	<form action="JavaTest01" method = "get">
		Ŭ���̾�Ʈ �̸��� �Է��ϼ���:<br>
		<input type="text" name="clientName" size=20>
		<input type="submit", values="����">
	</form>
	
	<h2>JSP ������ ����� �ִ� html ȭ���Դϴ�.Post</h2>
	<form action="JavaTest01" method = "post">
		Ŭ���̾�Ʈ �̸��� �Է��ϼ���:<br>
		<input type="text" name="clientName" size=20>
		<input type="submit", values="����">
	</form>


</body>
</html>