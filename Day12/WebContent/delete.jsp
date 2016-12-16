<%@page import="service.BoardService"%>
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
	request.setCharacterEncoding("euc-kr");
	String articleIdStr = request.getParameter("articleId");
	String pwd = request.getParameter("pwd");
	int articleId = 0;
	if(articleIdStr != null && articleIdStr.length()>0 ) {
		articleId = Integer.parseInt(articleIdStr);
	}
	
	ArticleVO article = new ArticleVO();
	article.setPassword(pwd);
	article.setArticleId(articleId);
	
	BoardService service = BoardService.getInstance();
	int result = service.delete(article);
%>
<% if(result == 1) { %>
<script type="text/javascript">
alert("삭제 완료")
location.href="board.jsp"
</script>
<%} else { %>
<script type="text/javascript">
alert("삭제 실패")
location.href="board_list.jsp";
</script>
<%} %>


</body>
</html>