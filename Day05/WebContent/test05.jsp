<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>test05.jsp</title>
</head>
<body>
<%
	// 스크립트 부분은 어차피 클라이언트에게 보내는
	// html에는 들어가지 않으므로 이 주석은 클라이언트가 볼일 없음.
%>

<h2>주석 내용을 테스트하는 페이지입니다.</h2>
<!-- 이 문장은 클라이언트에게 전송 될까요?(html 주석) -->
<%-- 이 문장은 클라이언트에게 전송 될까요?(jsp 주석) --%>

</body>
</html>