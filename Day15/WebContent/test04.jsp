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
<h2>c:if 태그 활용해보기</h2>
	<c:if test="true">
		이 내용은 무조건 html 문서에 쓰여집니다.<br>
	</c:if>
	
	<c:if test="true ">
		띄어쓰기가 있어서 true가 true가 아닌것이다.<br>
	</c:if>
	
	<c:if test="${param.name == 'taemin'}">
		안녕 태민아.<br>
	</c:if>

	<c:if test="${param.age >= 20}">
		성인이다.<br>
	</c:if>
	
<!--else if 문을 사용할 수 없으니 조건을 반대로 주면 됨 -->
	<c:if test="${param.age < 20}">
		미성년자이다.<br>
	</c:if>
	
	
</body>
</html>