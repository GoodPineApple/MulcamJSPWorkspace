<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${article.title}</title>
</head>
<body>
<c:if test="${not empty sessionScope.name}">
	<input type="hidden" name="action" value="write">
	<table border="1">
		<tr>
			<td>����</td>
			<td>${article.title}</td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td>${article.id}</td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td>${article.writeDate}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${article.content}</td>
		</tr>	
		
	</table>
	<hr>
	<h3>���</h3>
	<table>
		<c:forEach var="comment" items="${commentPage.commentList}">
		<tr>
			<td>${comment.id}</td>
			<td>${comment.content}</td>
		</tr>
		</c:forEach>
		
		
	</table>
	<a href="board.do?action=main"><button>�������</button></a>
	<a href="board.do?action=updateForm&articleNum=${article.articleNum}"><button>����</button></a>
	<a href="board.do?action=delete&articleNum=${article.articleNum}"><button>����</button></a>
</c:if>
<c:if test="${empty sessionScope.name}">
<script type="text/javascript">
	alert("�α����� �ʿ��� �����Դϴ�.")
	location.href = "/Day18_loginBoard/";
</script>
</c:if>
</body>
</html>