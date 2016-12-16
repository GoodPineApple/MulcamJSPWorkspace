<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test05_login_status.jsp</title>
</head>
<body>
<%
//클라이언트가 보낸 request에는 로그인관련 쿠키 외에도 다른 쿠키들이 여러개 존재할 수 있음.
	Cookie[] cookies = request.getCookies();
	Cookie loginCookie = null;

	if(cookies != null) {
		for(Cookie c : cookies) {
			if(c.getName().equals("loginId")) {
				loginCookie = c;
			}
		}
	}

	if(loginCookie == null) {
		out.println("로그인 정보가 없습니다.<br>");
		out.println("<a href='test05_login_form.jsp'>로그인폼으로가기</a>");
	} else {
		out.println(loginCookie.getValue() + "님 로그인 상태입니다. <br>");
		out.println("반갑습니다. <br>");
		out.println("<a href='test05_logout.jsp'>로그아웃</a>");
	}

%>


</body>
</html>