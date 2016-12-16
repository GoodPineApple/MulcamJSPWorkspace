<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test08.jsp</title>
</head>
<body>
	<c:set var="price" value="0.14"/>
	���� : 
	<fmt:formatNumber value="${price}" type="number"/> <br>
	��ȭ : 
	<fmt:formatNumber value="${price}" type="number" currencySymbol="$"/> <br>
	�ۼ�Ʈ : 
	<fmt:formatNumber value="${price}" type="percent" groupingUsed="false"/> <br>
	���� : 
	<fmt:formatNumber value="${price}" pattern="00000.000"/> <br>
</body>
</html>