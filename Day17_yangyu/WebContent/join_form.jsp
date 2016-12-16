<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>join_form.jsp</title>
</head>
<body>
<h3>회원가입 화면</h3>
<form action="member.do" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" size="20">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="password" size="20">
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name" size="20">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="email" size="20">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="회원가입">
		</td>
	</tr>
</table>
	<input type="hidden" name="action" value="join">
</form>
</body>
</html>