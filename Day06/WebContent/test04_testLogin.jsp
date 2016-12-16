<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String id="taeminKim";
String pwd="1111";
String name="±èÅÂ¹Î";
request.setCharacterEncoding("UTF-8");
if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
	response.sendRedirect("test04_main.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
} else {
	response.sendRedirect("04_loginForm.jsp");
}
%>
