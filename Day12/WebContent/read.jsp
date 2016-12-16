<%@page import="service.BoardService"%>
<%@page import="vo.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>read.jsp</title>
</head>
<body>
<%
	String articleIdStr = request.getParameter("articleId");
	int articleId = 0;

	if(articleIdStr != null && articleIdStr.length()>0) {
		articleId = Integer.parseInt(articleIdStr);
	}
	
	BoardService service = BoardService.getInstance();
	ArticleVO article = service.read(articleId);
	if(article == null) {
		out.println("<h4>해당 게시글이 존재하지 않습니다.</h4>");
	} else {%>
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
	
	<%} %>
<a href="board_list.jsp"><button>목록보기</button></a>
<a href="update_form.jsp?articleId=<%=article.getArticleId()%>"><button>수정</button></a>
<a href="delete_form.jsp?articleId=<%=article.getArticleId()%>"><button>삭제</button></a>
</body>
</html>