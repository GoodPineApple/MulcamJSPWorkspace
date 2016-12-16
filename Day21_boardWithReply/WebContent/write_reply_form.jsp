<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>답글작업</title>
</head>
<body>
<c:if test="${not empty sessionScope.name}">
<form action="board.do" method="post">
	<input type="hidden" name="action" value="write_reply">
	<input type="hidden" name="articleNum" value="${article.articleNum}">
	<input type="hidden" name="replyGrp" value="${article.replyGrp}">
	<input type="hidden" name="replyLevel" value="${article.replyLevel}">
	<input type="hidden" name="replyIndex" value="${article.replyIndex}">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" size="20" 
			value="<c:forEach var="i" begin="1" end="${article.replyLevel}">re:</c:forEach>"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="30" name="content" placeholder = "내용입력하세요."></textarea>
		</tr>	
		<tr>
			<td colspan="2"><input type="submit" value="글쓰기"></td>
		</tr>	
	</table>
</form>
</c:if>

</body>
</html>