<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04.jsp</title>
</head>
<body>
<h2>c:if �±� Ȱ���غ���</h2>
	<c:if test="true">
		�� ������ ������ html ������ �������ϴ�.<br>
	</c:if>
	
	<c:if test="true ">
		���Ⱑ �־ true�� true�� �ƴѰ��̴�.<br>
	</c:if>
	
	<c:if test="${param.name == 'taemin'}">
		�ȳ� �¹ξ�.<br>
	</c:if>

	<c:if test="${param.age >= 20}">
		�����̴�.<br>
	</c:if>
	
<!--else if ���� ����� �� ������ ������ �ݴ�� �ָ� �� -->
	<c:if test="${param.age < 20}">
		�̼������̴�.<br>
	</c:if>
	
	
</body>
</html>