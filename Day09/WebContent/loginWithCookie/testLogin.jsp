<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
//�����δ� DB���� �����;��ϴ� ��
String id="taemin";
String pwd="1234";
String name="KimTaemin";

if(id.equals(request.getParameter("id"))&&pwd.equals(request.getParameter("pwd"))) {
	Cookie cookie = new Cookie(name,name);
	response.addCookie(cookie);
	response.sendRedirect("main.jsp");
%>
	<h2> ���������� �α����ϼ̽��ϴ�.</h2>
	<p> <a href="main.jsp"> ����</a>
<%
} else {
	response.sendRedirect("loginForm.jsp");
}
%>




