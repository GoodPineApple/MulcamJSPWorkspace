<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� �б�</title>
</head>
<body>
<table border="1">
	<tr>
		<td>����</td>
		<td>${article.title}</td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td><fmt:formatDate value="${article.writeDate}" type="both" dateStyle="short" timeStyle="short" /></td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td>${article.writer}</td>
	</tr>
	<tr>
		<td>����</td>
		<td width="200" height="100">${article.content}</td>
	</tr>
</table>
<a href="board.do?action=toconfirmPassword&articleId=${article.articleId}&type=update"><button>�����ϱ�</button></a>
<a href="board.do?action=toconfirmPassword&articleId=${article.articleId}&type=delete"><button>�����ϱ�</button></a>
<a href="board.do?action=main"><button>��Ϻ���</button></a>
</body>
</html>