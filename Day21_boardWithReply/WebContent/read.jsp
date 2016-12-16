<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${article.title}</title>
</head>
<body>
<c:if test="${not empty sessionScope.name}">
	<input type="hidden" name="action" value="write">
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${article.title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.id}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><fmt:formatDate value="${article.writeDate}" type="both" dateStyle="short" timeStyle="short"/>  </td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${article.content}</td>
		</tr>	
		
	</table>
	<hr>
	<h3>댓글</h3>
	<table>
		<c:forEach var="comment" items="${commentPage.commentList}">
		<tr>
			<td>${comment.id}</td>
			<td>${comment.content}(<fmt:formatDate value="${comment.writeDate}" type="both" dateStyle="short" timeStyle="short"/> )</td>
			<td>Good^.^<a href="board.do?action=commentGood&commentNum=${comment.commentNum}
						&articleNum=${article.articleNum}">(${comment.good})</a></td>
			<td> ////Bad T.T<a href="board.do?action=commentBad&commentNum=${comment.commentNum}
							&&articleNum=${article.articleNum}">(${comment.bad})</a></td>
			<c:if test="${sessionScope.userId==comment.id}">
			<td><a href="board.do?action=deleteComment&commentNum=${comment.commentNum}
							&&articleNum=${article.articleNum}"><button>삭제</button></a></td>
			</c:if>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="2">
				<c:if test="${commentPage.startPage>1}">
					<a href="board.do?action=read&articleNum=${article.articleNum}
					&commentPageNum=${commentPage.startPage-1}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${commentPage.startPage}" end="${commentPage.endPage}">
					<a href="board.do?action=read&articleNum=${article.articleNum}
					&commentPageNum=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${commentPage.endPage<commentPage.totalPage}">
					<a href="board.do?action=read&articleNum=${article.articleNum}
					&commentPageNum=${commentPage.endPage+1}">[다음]</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="board.do" method="post">
					<input type="hidden" name="action" value="commentWrite">
					<input type="hidden" name="articleNum" value="${article.articleNum}">
					${sessionScope.userId} : <input type="text" name="content" size="60">
					<input type="submit" value="댓글쓰기">
				</form>
			</td>
		</tr>
	</table>
	<hr>
	<a href="board.do?action=main"><button>목록으로</button></a>
	<a href="board.do?action=writeReply&articleNum=${article.articleNum}&replyGrp=${article.replyGrp}&replyLevel=${article.replyLevel}&replyIndex=${article.replyIndex}"><button>답글달기</button></a>
	<c:if test="${sessionScope.userId==article.id}">
	<a href="board.do?action=updateForm&articleNum=${article.articleNum}"><button>수정</button></a>
	</c:if>
	<c:if test="${sessionScope.userId==article.id}">
	<a href="board.do?action=delete&articleNum=${article.articleNum}"><button>삭제</button></a>
	</c:if>
	
</c:if>
<c:if test="${empty sessionScope.name}">
<script type="text/javascript">
	alert("로그인이 필요한 서비스입니다.")
	location.href = "/Day21_boardWithReply/";
</script>
</c:if>
</body>
</html>