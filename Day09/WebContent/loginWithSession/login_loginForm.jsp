<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login_loginForm.jsp</title>
</head>
<body>
<form method = "post" action="login_testLogin.jsp">
	<label for="userid"> 아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	
	<label for="userpwd"> 암  &nbsp; 호 : </label>
	<input type="password" name="pwd" id="userpwd">
	
	<input type="submit" value="로그인">
</body>
</html>