<%@page import="vo.ArticleVO"%>
<%@page import="vo.ArticlePageVO"%>
<%@page import="service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board_list.jsp</title>
</head>
<body>
	<%
		String pageStr = request.getParameter("page");
		int pageNum = 1;
		if (pageStr != null && pageStr.length() > 0) {
			pageNum = Integer.parseInt(pageStr);
		}

		BoardService service = BoardService.getInstance();
		ArticlePageVO articlePage = service.makePage(pageNum);
	%>
	
	<a href="write_form.jsp"><button>글쓰기</button></a>
	
	<table border="">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			if (articlePage.getArticleList().size() == 0) {
		%>
		<tr>
			<td colspan="5">아직 게시글이 존재하지 않습니다.</td>
		</tr>
		<%
			} else {
		%>
		<%
			for (ArticleVO article : articlePage.getArticleList()) {
		%>
		<tr>
			<td><%=article.getArticleId()%></td>
			<td>
			<a href="read.jsp?articleId=<%=article.getArticleId()%>"><%=article.getTitle()%></a>
			</td>
			<td><%=article.getWriter()%></td>
			<td><%=article.getWriteDate()%></td>
			<td><%=article.getReadCount()%></td>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	<%if(articlePage.getStartPage()>1){ %>
		<a href="board_list.jsp?page=<%=articlePage.getStartPage()-1%>">[이전]</a>
	<%} %>
	
	<% for(int i=articlePage.getStartPage(); i<=articlePage.getEndPage(); i++) {%>
		<a href="board_list.jsp?page=<%=i%>">[<%=i%>]</a>
	<% }%>
	
	<%if(articlePage.getEndPage()<articlePage.getTotalPage()){ %>
		<a href="board_list.jsp?page=<%=articlePage.getEndPage()+1%>">[다음]</a>
	<%}%>

</body>
</html>