<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSP</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
Cookie ck[] = request.getCookies();

if(cookies != null) {
	for(Cookie cookie : ck) {
		if(cookie.getName().equals("KimTaemin")) {
			out.print(cookie.getValue());
		}
	}
	%>
	�� �ȳ��ϼ���!<br>
	���� Ȩ�������� �湮�� �ּż� �����մϴ�.<br>
	��ſ� �ð� �Ǽ���.....<br>
	<form method="post" action="logout.jsp">
		<input type="submit" value="�α׾ƿ�">
	</form>
<% 
} else {
%>
	<h2> �α��ο� �����߽��ϴ�.</h2>
	<p><a href="loginForm.jsp"> �ǵ��ư��� </a>
<% 
}
%>
</body>
</html>