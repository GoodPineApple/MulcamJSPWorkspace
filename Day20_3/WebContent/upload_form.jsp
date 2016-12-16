<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>upload_form.jsp</title>
</head>
<body>
	<form action="file.do" method="post" enctype="multipart/form-data">
		파일 선택 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="제출">
	</form>
</body>
</html>