<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write_form.jspe</title>
</head>
<body>
<form action="board.do" method="post">
	제목 : <input type="text" name="title" size="20"><br>
	내용 : <textarea name="contnent" rows="5" cols="20" placeholder="내용작성"></textarea><br>
	<input type="hidden" name="action" value="write">
		<input type="submit" value="작성완료">
</form>
</body>
</html>