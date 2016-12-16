<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write_form.jsp</title>
</head>
<body>
<form action="write.jsp" method="post">
	<table border="1">
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="title" size="30">
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<input type="text" name="writer" size="30">
			</td>
		</tr>
		<tr>
			<td>암호</td>
			<td>
				<input type="password" name="password" size="30">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="30" name="content" placeholder="여기에 내용을 입력하세요."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "2">
			<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>

</form>

</body>
</html>