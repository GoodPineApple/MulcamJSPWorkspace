<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>delete_form.jsp</title>
</head>
<body>
<%
	String articleIdStr = request.getParameter("articleId");
	int articleId = 0;
	if(articleIdStr != null && articleIdStr.length()>0){
		articleId = Integer.parseInt(articleIdStr);
	}
	
%>
<form action = "delete.jsp">
	이 게시물을 삭제하시겠습니까?<br>
	비밀번호 : <input type="password" name="pwd" size="20" placeholder="***************">
	<input type="submit" value="삭제">
	<input type="hidden" name="articleId" value="<%=articleId%>">
</form>
<hr>
<a href="board_list.jsp"><button>목록으로</button></a>

</body>
</html>