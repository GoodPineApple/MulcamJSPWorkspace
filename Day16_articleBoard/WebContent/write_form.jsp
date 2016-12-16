<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="board.do" method="post">
<table border = "1">
	<input type="hidden" name="action" value="writeForm">
	<tr>
		<td>제목</td> 
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content" col="40" row="50" placeholder="내용을 입력하세요"></textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="글쓰기"></td>
	</tr>
</table>
</form>
</body>
</html>