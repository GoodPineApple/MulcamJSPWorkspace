<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ùȭ��</title>
</head>
<body>
<c:if test="${empty sessionScope.name}">
	<form action="member.do" method="post">
		<input type="hidden" name="action" value="login">
		I &nbsp;D : <input type="text" name="id" size="20"> <br>
		PW : <input type="password" name="password" size="20" placeholder="***********"><br>
		<input type="submit" value="�α���">
	</form> 
	<hr>
	���̵� ��������? <a href="member.do?action=joinForm"><button>ȸ������</button></a>
</c:if>
<c:if test="${not empty sessionScope.name}">
	${sessionScope.name}�� �ȳ��ϼ���!
	<a href="member.do?action=logout"><button>�α׾ƿ�</button></a>
</c:if>
<hr>
	<a href="board.do?action=main">�Խñ� Ȯ���Ϸ� ����</a>

</body>
</html>