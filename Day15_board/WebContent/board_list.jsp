<%@page import="vo.ArticleVO"%>
<%@page import="vo.ArticlePageVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board_list.jsp</title>
</head>
<body>

<h2>게시글 목록</h2>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>제   목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:choose>
		<c:when test="${empty articlePage.articleList}">
	<tr>	
		<td colspan="5">작성된 게시글이 없습니다.</td>
	</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${articlePage.articleList}" var="article">
			<tr>
				<td>${article.articleId}</td>
				<td><a href="board.do?action=read&articleId=${article.articleId}">
					${article.title}</a></td>
				<td>${article.writer}</td>
				<td>${article.writeDate}</td>
				<td>${article.readCount}</td>
			</tr>	
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<c:forEach begin="${articlePage.startPage}" end="${articlePage.endPage}" var="i">
		<a href="board.do?action=main&page=${i}">[${i}]</a>
</c:forEach>
	<br>
	<a href="board.do?action=writeForm"><button>글쓰기</button></a>


</body>
</html>