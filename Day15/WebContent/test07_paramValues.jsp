<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL�� JSTL</title>
</head>
<body>

<%-- <%request.setCharacterEncoding("euc-kr");%> --%>
<fmt:requestEncoding value="euc-kr"/>
	����� ������ �׸��Դϴ�.<hr>
<c:forEach var="item" items="${paramValues.item}" varStatus="status">
${item} <c:if test="${not status.last}">, </c:if>

</c:forEach>
</body>
</html>