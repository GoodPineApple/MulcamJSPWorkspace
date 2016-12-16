<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
<form action="member.do" method="post">
<input type="hidden" name="action" value="join">
<table>
	<tr>
		<td>I D</td>
		<td>:<input type="text" name="id" size="20"></td>
	</tr>
	<tr>
		<td>P W</td>
		<td>:<input type="password" name="password" size="20"></td>
	</tr>
	<tr>
		<td>이   름</td>
		<td>:<input type="text" name="name" size="20"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td>:<input type="text" name="email" size="20"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="checkbox" name="gender" value="man"> 남성
		<input type="checkbox" name="gender" value="woman"> 여성
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="회원가입">
		</td>
	</tr>
</table>

</form>

</body>
</html>