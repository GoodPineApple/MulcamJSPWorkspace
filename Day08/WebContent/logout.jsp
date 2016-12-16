<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	//쿠키삭제 메소드 사용
	Cookie cookie = new Cookie("cookie1", "");  //이름은 중요 value는 상관없음
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	
	request.setCharacterEncoding("UTF-8");
	response.sendRedirect("login_form.jsp");
		
%>