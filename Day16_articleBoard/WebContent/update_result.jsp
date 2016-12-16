<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>updateresult.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${result}==1">
			<h2>수정 완료 ${result}</h2>
		</c:when>
		<c:otherwise>
			<h2>수정 실패 ${result}</h2>
		</c:otherwise>
	</c:choose>
<a href="board.do?action=main"><button>목록으로</button></a>

</body>
</html>