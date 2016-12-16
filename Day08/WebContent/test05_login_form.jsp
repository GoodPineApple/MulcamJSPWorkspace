<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test05_login_form.jsp</title>
</head>
<body>
<form method="post" action="test05_login_check.jsp">
	ID : <input type = "text" name="id" placeholder="여기에 아이디를 입력하세요." size=30><br>
	PW : <input type="password" name="pw" id="userpwd" placeholder="********" size=30><br>
	<input type="submit" value="Login">
</form>

</body>
</html>