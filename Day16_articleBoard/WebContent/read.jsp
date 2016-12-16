<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 읽기</title>
</head>
<body>
<table border="1">
	<tr>
		<td>제목</td>
		<td>${article.title}</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td><fmt:formatDate value="${article.writeDate}" type="both" dateStyle="short" timeStyle="short" /></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${article.writer}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td width="200" height="100">${article.content}</td>
	</tr>
</table>
<a href="board.do?action=toconfirmPassword&articleId=${article.articleId}&type=update"><button>수정하기</button></a>
<a href="board.do?action=toconfirmPassword&articleId=${article.articleId}&type=delete"><button>삭제하기</button></a>
<a href="board.do?action=main"><button>목록보기</button></a>
</body>
</html>