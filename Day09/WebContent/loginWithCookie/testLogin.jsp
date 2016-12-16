<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
//실제로는 DB에서 가져와야하는 값
String id="taemin";
String pwd="1234";
String name="KimTaemin";

if(id.equals(request.getParameter("id"))&&pwd.equals(request.getParameter("pwd"))) {
	Cookie cookie = new Cookie(name,name);
	response.addCookie(cookie);
	response.sendRedirect("main.jsp");
%>
	<h2> 성공적으로 로그인하셨습니다.</h2>
	<p> <a href="main.jsp"> 들어가기</a>
<%
} else {
	response.sendRedirect("loginForm.jsp");
}
%>




