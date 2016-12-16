<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//test05_a.jsp
	String n = request.getParameter("name");
	System.out.println("test05_a.jsp name :" + n);

	response.sendRedirect("test05_b.jsp");
%>