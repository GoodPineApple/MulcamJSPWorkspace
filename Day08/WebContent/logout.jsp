<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	//��Ű���� �޼ҵ� ���
	Cookie cookie = new Cookie("cookie1", "");  //�̸��� �߿� value�� �������
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	
	request.setCharacterEncoding("UTF-8");
	response.sendRedirect("login_form.jsp");
		
%>