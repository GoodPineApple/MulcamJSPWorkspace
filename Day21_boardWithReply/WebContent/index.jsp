<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>첫화면</title>
</head>
<body>
<c:if test="${empty sessionScope.name}">
	<form action="member.do" method="post">
		<input type="hidden" name="action" value="login">
		I &nbsp;D : <input type="text" name="id" size="20"> <br>
		PW : <input type="password" name="password" size="20" placeholder="***********"><br>
		<input type="submit" value="로그인">
	</form> 
	<hr>
	아이디가 없으세요? <a href="member.do?action=joinForm"><button>회원가입</button></a>
</c:if>
<c:if test="${not empty sessionScope.name}">
	${sessionScope.name}님 안녕하세요!
	<a href="member.do?action=logout"><button>로그아웃</button></a>
</c:if>
<hr>
	<a href="board.do?action=main">게시글 확인하러 가기</a>

</body>
</html>