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
	ArticleVO article = (ArticleVO)request.getAttribute("article");
%>
<table border="1">
		<tr>
			<td>제목 : </td>
			<td><%=article.getTitle() %></td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td><%=article.getWriter() %></td>
		</tr>
		<tr>
			<td>조회수 : </td>
			<td><%=article.getReadCount() %></td>
		</tr>
		<tr>
			<td>작성일 : </td>
			<td><%=article.getWriteDate() %></td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td><%=article.getContent() %></td>
		</tr>
	</table>

<a href="board.do?action=main"><button>목록보기</button></a>
<a href="board.do?action=updateForm&articleId=<%=article.getArticleId()%>"><button>수정</button></a>
<a href="board.do?action=deleteForm&articleId=<%=article.getArticleId()%>"><button>삭제</button></a>

</body>
</html>