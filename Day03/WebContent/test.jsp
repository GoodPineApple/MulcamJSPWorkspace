<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>폼을 만들어주는 JSP</title>
</head>
<body>
	<h2>JSP 서블릿이 만들어 주는 html 화면입니다.Get</h2>
	<form action="JavaTest01" method = "get">
		클라이언트 이름을 입력하세요:<br>
		<input type="text" name="clientName" size=20>
		<input type="submit", values="전송">
	</form>
	
	<h2>JSP 서블릿이 만들어 주는 html 화면입니다.Post</h2>
	<form action="JavaTest01" method = "post">
		클라이언트 이름을 입력하세요:<br>
		<input type="text" name="clientName" size=20>
		<input type="submit", values="전송">
	</form>


</body>
</html>