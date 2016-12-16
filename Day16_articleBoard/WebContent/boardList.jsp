<%@page import="vo.ArticleVO"%>
<%@page import="vo.PageVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판</title>
</head>
<body>

	<h1>Talk What You Think</h1>
	<table border="1" style="width: 70%; text-align: center;">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty articlePage.articleList}">
				<tr>
					<td colspan="5">작성된 게시물이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="article" items="${articlePage.articleList}">
					<tr>
						<td>${article.articleId}</td>
						<td><a href="board.do?action=read&articleId=${article.articleId}">${article.title}</a></td>
						<td>${article.writer}</td>
						<td><fmt:formatDate value="${article.writeDate}" type="both" dateStyle="short" timeStyle="short" /></td>
						<td>${article.readCount}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<table border="1" style="width: 70%; text-align: center">
		<tr>
			<td><c:if test="${articlePage.startPage>10}">
				<a href="board.do?action=main&page=${articlePage.startPage-1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${articlePage.startPage}"
				end="${articlePage.endPage}">
				<a href="board.do?action=main&page=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${articlePage.endPage<articlePage.totalPage}">
				<a href="board.do?action=main&page=${articlePage.endPage+1}">[다음]</a>
			</c:if>
			<td><a href="board.do?action=write"><button>글쓰기</button></a></td>
		</tr>
	</table>
</body>
</html>