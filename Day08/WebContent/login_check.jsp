<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	String id="taemin";
	String pwd="1234";
	String name="���¹�";
	request.setCharacterEncoding("UTF-8");
	if(id.equals(request.getParameter("id"))&& pwd.equals(request.getParameter("pwd"))) {
		Cookie cookie = new Cookie("cookie", "cooooKieeeee");
		response.addCookie(cookie);
		response.sendRedirect("login_status.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	}
	else {
		response.sendRedirect("login_fail_status.jsp?name=" + URLEncoder.encode(name,"UTF-8"));
	}
	
%>