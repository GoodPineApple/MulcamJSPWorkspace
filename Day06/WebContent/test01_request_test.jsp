<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//request에 들어있는 파라미터에 한글이 있을 경우를 고려함
	request.setCharacterEncoding("euc-kr");

	String msg = request.getParameter("msg");
	String addr = request.getRemoteAddr();
	System.out.println(addr + "->msg:" + msg);

%>

당신의 아이피는 <%=addr %>입니다. <br>

</body>
</html>