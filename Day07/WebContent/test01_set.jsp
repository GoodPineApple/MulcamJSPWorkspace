<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>test01_set.jsp</title>
</head>
<body>
<%
	application.setAttribute("attr1", new Date());
	application.setAttribute("attr2", "Yangyu");
%>
���� ������ ��û�� �޾��� ��<br>
application �⺻ ��ü�� attr1, attr2 �ΰ��� �Ӽ���<br>
��� �Ͽ����ϴ�.<br>

</body>
</html>