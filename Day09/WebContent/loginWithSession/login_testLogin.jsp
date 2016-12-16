<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String id = "taemin";
String pwd = "1234";
String name = "±èÅÂ¹Î";

if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))){
	session.setAttribute("loginUser", name);
	response.sendRedirect("login_main.jsp");
}
else {
	response.sendRedirect("login_loginForm.jsp");
}
%>


