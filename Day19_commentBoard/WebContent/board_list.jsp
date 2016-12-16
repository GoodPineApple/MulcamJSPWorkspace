<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판</title>
</head>
<body>
<h2>게시판</h2>
<a href = "board.do?action=writeForm"><button>글쓰기</button></a>
<a href = "member.do?action=main"><button>목록으로</button></a>
	<table border="1">
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
<c:if test="${articlePage.startPage>10}">
<a href="board.do?page=${articlePage.startPage-1}"><button>[이전]</button></a>
</c:if>
<c:forEach var="i" begin="${articlePage.startPage}" end="${articlePage.endPage}">
<a href="board.do?page=${i}">[${i}]</a>
</c:forEach>
<c:if test="${articlePage.endPage<articlePage.totalPage}">
<a href="board.do?page=${articlePage.endPage+1}"><button>[이전]</button></a>
</c:if>

</body>
</html>