<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login_status.jsp</title>
</head>
<body>
<h2>[�α��� Ȯ��]</h2>
���� Ȩ�������� �湮���ּż� �����մϴ�. <br>
��ȸ������ ��Ű�Դϴ�.<br>
<hr>
<% 
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie cookie : cookies) {
			out.print("��Ű�̸�:"+cookie.getName()+"<br>");
			out.print("��Ű��:"+cookie.getValue()+"<br>");
			out.print("<hr>");
		}
	}
%> 
�Ʒ��� �α׾ƿ��Դϴ�.<br>
<form action="logout.jsp">
	<input type="submit" value="�α׾ƿ�">
</form>
</body>
</html>