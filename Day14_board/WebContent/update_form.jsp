<%@page import="vo.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ArticleVO original = (ArticleVO)request.getAttribute("original");
%>

<form action="board.do" method="post">
<input type="hidden" name="action" value="update">
	<table border="1">
		<tr>
			<td>����</td>
			<td>
				<input type="text" name="title" size="30" value="<%=original.getTitle()%>">
			</td>
		</tr>
		<tr>
			<td>��ȣ</td>
			<td>
				<input type="password" name="password" size="30">
			</td>
		</tr>
		<tr>
			<td>����</td>
			<td>
				<textarea rows="10" cols="30" name="content" placeholder="���⿡ ������ �Է��ϼ���."><%=original.getContent()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "2">
			<input type="hidden" name="articleId" value="<%=original.getArticleId()%>">
			<input type="submit" value="�ۼ��Ϸ�">
			</td>
		</tr>
 	</table>


</form>


</body>
</html>