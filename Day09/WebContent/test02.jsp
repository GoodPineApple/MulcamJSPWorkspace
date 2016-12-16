<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test02.jsp</title>
</head>
<body>
<%
//web.xml에 설정된 세션유효시간은 5분이지만
//이 서블릿에 요청을 보내는 순간
//해당 클라이언트의 세션은 유효시간이 60초로 변경
	session.setMaxInactiveInterval(60);
%>
현재 세션 ID : <%=session.getId() %>
</body>
</html>