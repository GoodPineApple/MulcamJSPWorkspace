<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ڷ��</title>
</head>
<body>
<h3>�ڷ��</h3>
<table border="1">
	<tr>
		<th>���Ϲ�ȣ</th>
		<th>�����̸�</th>
		<th>������</th>
		<th>�ٿ�Ƚ��</th>
		<th>����ũ��</th>
	</tr>
	<tr>
		<c:if test="${empty requestScope.fileList}">
			<td colspan="5">�ۼ��� �Խù��� �����ϴ�.</td>
		</c:if>
	</tr>
	<c:if test="${not empty requestScope.fileList}">
		<c:forEach var="file" items="${requestScope.fileList}" >
			<tr>
				<td>${file.fileNum}</td>
				<td>${file.fileName}</td>
				<td>${file.savedPath}</td>
				<td>${file.downCount}</td>
				<td>${file.fileSize}</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<a href="file.do?action=uploadForm"><button>���Ͽø���</button></a>
</body>
</html>