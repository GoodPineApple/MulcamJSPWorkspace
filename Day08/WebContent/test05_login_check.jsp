<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test05_login_check.jsp</title>
</head>
<body>
	<% 
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	request.setCharacterEncoding("UTF-8");
	
	if(id.equals("admin")&& pw.equals("1234")) {
		out.print("�α����� �����Ͽ����ϴ�.");
		Cookie cookie = new Cookie("loginId", id);	
		response.addCookie(cookie);
		}
	else {
		out.print("�α����� �����Ͽ����ϴ�.");
		}
	
%>
	<a href="test05_login_status.jsp"><button>[�α��� ���º���]</button></a>

</body>
</html>