<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// test06_a.jsp (forward Test)
	String n = request.getParameter("name");
	System.out.println("test06_a.jsp name:" + n);
	
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("test06_b.jsp");
	dispatcher.forward(request, response);
	
%>