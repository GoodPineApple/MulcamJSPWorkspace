<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾���</title>
</head>
<body>
<c:if test="${not empty sessionScope.name}">
<form action="board.do" method="post">
	<input type="hidden" name="action" value="write">
	<table>
		<tr>
			<td>����</td>
			<td><input type="text" name="title" size="20"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><textarea rows="20" cols="30" name="content" placeholder = "�����Է��ϼ���."></textarea>
		</tr>	
		<tr>
			<td colspan="2"><input type="submit" value="�۾���"></td>
		</tr>	
	</table>
</form>
</c:if>
<c:if test="${empty sessionScope.name}">
<script type="text/javascript">
	alert("�α����� �ʿ��� �����Դϴ�.")
	location.href = "/Day21_boardWithReply/";
</script>
</c:if>
</body>
</html>