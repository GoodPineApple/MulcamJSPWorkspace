<%@page import="vo.ArticlePageVO"%>
<%@page import="vo.ArticleVO"%>
<%@page import="java.util.List"%>
<%@page import="service.BoardService"%>
<%@page import="dao.ArticleDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board.jsp</title>
</head>
<body>
<%
	String pageStr = request.getParameter("page");
	int pageNum = 1;
	if(pageStr != null && pageStr.length() != 0) {
		pageNum = Integer.parseInt(pageStr);
	}
	
	BoardService boardService = BoardService.getInstance();
	ArticlePageVO articles = boardService.makePage(pageNum);
%>

<a href="write_form.jsp"><button>�۾���</button></a>

<table border="1">
	<tr>
		<th>��ȣ</th>
		<th>����</th>
		<th>�ۼ���</th>
		<th>�ۼ���</th>
		<th>��ȸ��</th>
	</tr>
	<%if(articles.getArticleList().size() == 0) { %>
	<tr>
		<td colspan="5">��ϵ� �Խù��� �����ϴ�.</td>
	</tr>
	<%} else { 
		for(ArticleVO article : articles.getArticleList()){ %>
	<tr>
		<th><%=article.getBoardId() %></th>
		<th><%=article.getTitle()%></th>
		<th><%=article.getWriter()%></th>
		<th><%=article.getWriteDate()%></th>
		<th><%=article.getReadCount()%></th>
	</tr>
	<%}} %>


</table>
<%if(articles.getStartPage()>1) { %>
<a href="board.jsp?page=<%=articles.getStartPage()-1%>">[����]</a>
<%} for(int i=1; i==articles.getEndPage(); i++) {%>
<a href="board.jsp?page=<%=i%>">[<%=i %>]</a>
<%} if(articles.getEndPage()<articles.getTotalPage()) {%>
<a href="board.jsp?page=<%=articles.getEndPage()+1%>">[����]</a>
<%} %>
</body>
</html>