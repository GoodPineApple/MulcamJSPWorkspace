<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���� ���</title>
<style type="text/css">
b {
	font-size: 16pt;
}
</style>
</head>
<body>
	<h2>���� ���� ���</h2>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		out.println("�̸� : <b>" + name + "</b><br>");
	
		String gender = request.getParameter("gender");
		out.println("���� : ");
		if (gender.equals("male")) {
			out.println("<b>����</b><br>");
		} else {
			out.println("<b>����</b><br>");
		}
		
		String SeasonArr[] = request.getParameterValues("season");
		out.println("����� �����ϴ� ������ ");
		for(String season : SeasonArr) {
			int n = Integer.parseInt(season);
			switch (n) {
			case 1: out.println("<b> �� </b>�Դϴ�.");
					break;
			case 2: out.println("<b> ���� </b>�Դϴ�.");
			break;
			case 3: out.println("<b> ���� </b>�Դϴ�.");
			break;
			case 4: out.println("<b> �ܿ� </b>�Դϴ�.");
			break;
			}
		}
	%>
	<br>
	<b><a href='javascript:history.go(-1)'>�ٽ�</a></b>

</body>
</html>