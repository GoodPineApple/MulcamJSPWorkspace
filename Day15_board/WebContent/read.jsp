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
			<td>���� : </td>
			<td>${article.title}</td>
		</tr>
		<tr>
			<td>�ۼ��� : </td>
			<td><${article.writer}</td>
		</tr>
		<tr>
			<td>��ȸ�� : </td>
			<td>${article.readCount}</td>
		</tr>
		<tr>
			<td>�ۼ��� : </td>
			<td>${article.writeDate}</td>
		</tr>
		<tr>
			<td>���� : </td>
			<td>${article.content}</td>
		</tr>
	</table>

<a href="board.do?action=main"><button>��Ϻ���</button></a>
<a href="board.do?action=updateForm&articleId=${article.articleId}"><button>����</button></a>
<a href="board.do?action=deleteForm&articleId=${article.articleId}"><button>����</button></a>

</body>
</html>