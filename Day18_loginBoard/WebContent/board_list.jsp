<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ���</title>
</head>
<body>
<h2>�Խ���</h2>
<a href = "board.do?action=writeForm"><button>�۾���</button></a>
	<table border="1">
		<tr>
			<th>�۹�ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ��</th>
		</tr>
		<c:choose>
			<c:when test="${empty articlePage.articleList}">
				<tr>
					<td colspan="5">�ۼ��� �Խù��� �����ϴ�.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="article" items="${articlePage.articleList}">
					<tr>
						<td>${article.articleNum}</td>
						<td><a href="board.do?action=read&articleNum=${article.articleNum}">${article.title}</a></td>
						<td>${article.id}</td>
						<td>${article.writeDate}</td>
						<td>${article.readCount}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
<hr>
<c:forEach var="i" begin="${articlePage.startPage}" end="${articlePage.endPage}"></c:forEach>
<a href="board.do?page=${i}">${i}</a>



</body>
</html>