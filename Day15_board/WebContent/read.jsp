<%@page import="vo.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<td>제목 : </td>
			<td>${article.title}</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td><${article.writer}</td>
		</tr>
		<tr>
			<td>조회수 : </td>
			<td>${article.readCount}</td>
		</tr>
		<tr>
			<td>작성일 : </td>
			<td>${article.writeDate}</td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td>${article.content}</td>
		</tr>
	</table>

<a href="board.do?action=main"><button>목록보기</button></a>
<a href="board.do?action=updateForm&articleId=${article.articleId}"><button>수정</button></a>
<a href="board.do?action=deleteForm&articleId=${article.articleId}"><button>삭제</button></a>

</body>
</html>