<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>file_list.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>���Ϲ�ȣ</th>
			<th>�����̸�</th>
			<th>������</th>
			<th>�ٿ�ε� Ƚ��</th>
			<th>����ũ��</th>
		</tr>
		<c:if test="${empty requestScope.fileList}">
		<tr>
			<td colspan="5">���ε�� ������ �����ϴ�.</td>
		</tr>
		</c:if>
		<c:if test="${not empty requestScope.fileList}">
			<c:forEach var="file" items="${fileList}">
				<tr>
					<td>${file.fileNum}</td>
					<td>
						<a href="down.do?action=download&fileNum=${file.fileNum}">${file.fileName}</a>
					</td>
					<td>${file.savedPath}</td>
					<td>${file.downCount}</td>
					<td>${file.fileSize}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<a href="file.do?action=uploadForm"><button>�����߰�</button></a>
</body>
</html>