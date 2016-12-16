<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글쓰기 결과창</title>
</head>
<body>
<c:choose>
	<c:when test="${result==1}">
		<script type="text/javascript">
			alert("글쓰기 완료");
			location.href = "/Day19_board/board.do";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("글쓰기 완료");
			location.href = "/Day19_board/board.do";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>