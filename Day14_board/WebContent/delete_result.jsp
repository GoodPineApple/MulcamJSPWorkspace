<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>delete_result.jsp</title>
</head>
<body>
<%
	int result = (Integer)request.getAttribute("deleteResult");
%>

<% if(result == 1) { %>
<script type="text/javascript">
alert("���� �Ϸ�")
location.href="board.do?action=main"
</script>
<%} else { %>
<script type="text/javascript">
alert("���� ����")
location.href="board.do?action=main";
</script>
<%} %>

<a href="board.do?action=main"><button>�Խñ� ���</button></a>

</body>
</html>