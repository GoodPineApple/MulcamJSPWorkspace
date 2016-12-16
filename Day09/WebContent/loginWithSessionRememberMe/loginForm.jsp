<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>loginForm.jsp</title>
</head>
<body>
<form action="loginTest.jsp" method="post">
<label for="userId"> 아이디 : </label>
<input type="text" naem="id" id="userId" placeholder="여기에 아이디를 입력하세요" size=25><br>

<label for="userpwd"> 암 &nbsp; 호 : </label>
<input type="password" name="pwd" id="userpwd" placeholder="********"><br>
<input type="submit" value="로그인">
</form>
</body>
</html>