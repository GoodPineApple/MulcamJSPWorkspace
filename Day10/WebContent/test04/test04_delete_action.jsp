<%@page import="sun.font.CreatedFontTracker"%>
<%@page import="repository.BookDAO"%>
<%@page import="vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test04_delete_action.jsp</title>
</head>
<body>
<%
	BookDAO dao = new BookDAO();
	int deleteBookNum = (int) session.getAttribute("delete");
	dao.delete(deleteBookNum);
	
	response.sendRedirect("test04_select_list.jsp");
%>

</body>
</html>