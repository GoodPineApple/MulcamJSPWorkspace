<%@page import="vo.ArticleVO"%>
<%@page import="vo.ArticlePageVO"%>
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
	ArticlePageVO articlePage = (ArticlePageVO) request.getAttribute("articlePage");
%>

<h2>게시글 목록</h2>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>제   목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<%if(articlePage.getArticleList().size() == 0) { %>
	<tr>	
		<td colspan="5">작성된 게시글이 없습니다.</td>
	</tr>
	<%} else {%>
		<%for(ArticleVO article : articlePage.getArticleList()){ %>
	<tr>
		<td><%=article.getArticleId() %></td>
		<td><a href="board.do?action=read&articleId=<%=article.getArticleId()%>">
			<%=article.getTitle() %></a></td>
		<td><%=article.getWriter() %></td>
		<td><%=article.getWriteDate() %></td>
		<td><%=article.getReadCount() %></td>
	</tr>	
	<%	} 
	}%>
</table>
	<%for(int i=articlePage.getStartPage(); i <= articlePage.getEndPage(); i++){ %>
		<a href="board.do?action=main&page=<%=i%>">[<%=i%>]</a>
	<%} %>
	<br>
	<a href="board.do?action=writeForm"><button>글쓰기</button></a>


</body>
</html>