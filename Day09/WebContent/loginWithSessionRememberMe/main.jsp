<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
</head>
<body>
	<%
		if (session.getAttribute("name") == null) {
			response.sendRedirect("loginForm.jsp");
		} else {
			out.println(session.getAttribute("name") + "�� �ȳ��ϼ���.");
	%>
	<h2>[�α��� �Ϸ�]</h2>
	ȯ���մϴ�.
	<br> �����Դϴ�. �Ʒ��� �α׾ƿ��Դϴ�.
	<br>
	<form action="loginForm.jsp" method="post">
		<input type="submit" value="�α׾ƿ�">
	</form>
	<%
		}
	%>




</body>
</html>