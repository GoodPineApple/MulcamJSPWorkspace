<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test02.jsp</title>
</head>
<body>
	<h2>악세사리</h2>
	관심항목을 선택하세요.<hr>
	<form action="JavaTest02" method="get">
		<input type="checkbox" name="item" value="shoes">신발
		<input type="checkbox" name="item" value="bag">가방
		<input type="checkbox" name="item" value="belt">벨트
		<input type="checkbox" name="item" value="cap">모자
		<input type="checkbox" name="item" value="watch">시계
		<input type="checkbox" name="item" value="jewelry">쥬얼리
		<input type="submit" value="전송">
	</form>

</body>
</html>