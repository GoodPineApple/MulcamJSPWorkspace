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
alert("삭제 완료")
location.href="board.do?action=main"
</script>
<%} else { %>
<script type="text/javascript">
alert("삭제 실패")
location.href="board.do?action=main";
</script>
<%} %>

<a href="board.do?action=main"><button>게시글 목록</button></a>

</body>
</html>