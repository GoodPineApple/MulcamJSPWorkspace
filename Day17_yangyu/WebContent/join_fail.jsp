<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join_fail.jsp</title>
</head>
<body>
<script type="text/javascript">
	//팝업 띄어버리기
	alert("회원가입 실패!");
	//메인으로 보내버리기
	location.href="/Day17_yangyu/member.do?action=joinForm";
</script>
</body>
</html>